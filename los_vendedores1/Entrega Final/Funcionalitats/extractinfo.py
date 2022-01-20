#!/bin/python
import googlemaps
import pandas as pd
import numpy as np
import matplotlib
import matplotlib.pyplot as plt
import matplotlib.colors as mcolors
from mpl_toolkits.basemap import Basemap
from itertools import chain
import io
import pickle
import os

itemsStaticData = {
	"biblioteca": {"c": "r", "class": "Biblioteques"},
	"llocs emblemàtics": {"c": "b", "class": "Llocs_emblematics"},
	"jardins": {"c": "g", "class": "Zona_Verda"},
	"zona comercial": {"c": "c", "class": "Zona_comercial"},
	"supermercat": {"c": "m", "class": "Supermercat_i_Hipermercats"},
	"hospital": {"c": "w", "class": "Hospital_o_CAP"},
	"gimnas": {"c": "y", "class": "Gimnas"},
	"escola": {"c": "pink", "class": "Escoles"},
	"estació": {"c": "bisque", "class": "Transport_Public"},
	"museu": {"c": "olive", "class": "Zona_Cultural"},
	"discoteca": {"c": "tan", "class": "Zona_Oci_Nocturn"},
	"platja": {"c": "moccasin", "class": "Platja"},
	"polígon industrial": {"c": "dimgray", "class": "Poligons_Industrials"},
}
itemsCoords = {}
if os.path.isfile('mapsdata.pkl'):
	with open('mapsdata.pkl', 'rb') as f:
		itemsCoords = pickle.load(f)
else:
	print("Fetching data")
	location = (41.39790491785889, 2.1646597182065626)
	API_KEY = open("API_KEY").read()
	mapCli = googlemaps.Client(API_KEY)
	distance = 10000
	for k in itemsStaticData.keys():
		response = mapCli.places_nearby(
			location=location,
			keyword=k,
			radius=distance)
		itemsCoords[k] = {}
		itemsCoords[k]["lat"] = []
		itemsCoords[k]["lon"] = []
		for i in response["results"]:
			itemsCoords[k]["lat"].append(i["geometry"]["location"]["lat"])
			itemsCoords[k]["lon"].append(i["geometry"]["location"]["lng"])
	with open('mapsdata.pkl', 'wb') as f:
		pickle.dump(itemsCoords, f)

lat = []
lon = []
for v in itemsCoords.values():
	lat.extend(v["lat"])
	lon.extend(v["lon"])

# determine range to print based on min, max lat and lon of the data
margin = 0.04 # buffer to add to the range
lat_min = min(lat) - margin
lat_max = max(lat) + margin
lon_min = min(lon) - margin
lon_max = max(lon) + margin

# create map using BASEMAP
m = Basemap(llcrnrlon=lon_min,
            llcrnrlat=lat_min,
            urcrnrlon=lon_max,
            urcrnrlat=lat_max,
            lat_0=(lat_max - lat_min)/2,
            lon_0=(lon_max-lon_min)/2,
            projection='merc',
            resolution = 'f',
            )
m.drawcoastlines(color="#2a9df4ff")
m.drawcountries()
m.drawrivers(color="#2a9df4ff")
m.drawmapboundary(fill_color='#2a9df4ff')
m.fillcontinents(color="#f8efe8ff", lake_color="#2a9df4ff")

with open("data.clips", "w") as f:
	for k in itemsCoords.keys():
		# convert lat and lon to map projection coordinates
		lons, lats = m(itemsCoords[k]["lon"], itemsCoords[k]["lat"])

		f.write("(definstances services_{}\n".format(itemsStaticData[k]["class"]))
		for i in range(0, len(lons)):
			f.write("({}_{} of {} (ubicacio_x {}) (ubicacio_y {}))\n".format(
				itemsStaticData[k]["class"],
				i,
				itemsStaticData[k]["class"],
				itemsCoords[k]["lat"][i],
				itemsCoords[k]["lon"][i]))
		f.write(")\n")

		# plot points as dots
		m.scatter(lons, lats, marker = 'o', color=itemsStaticData[k]["c"], zorder=5, s=1.2)
plt.show()
