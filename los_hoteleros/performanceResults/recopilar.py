import re
import math
import xlsxwriter

pattern = re.compile("([0-9.]+) seconds total time")


workbook = xlsxwriter.Workbook('Temps.xlsx')
worksheet = workbook.add_worksheet()

def extract(lines):
	for match in re.finditer(pattern, lines[len(lines)-2]):
		return match.group(1)
	return 10*60

for hab in range(1,11):
	for soli in range(1,11):
		sol = soli*10
		with open(f"result.{hab}.{sol}.txt", "r") as file:
			val = extract(file.readlines())
			worksheet.write(hab, soli, val)

workbook.close()