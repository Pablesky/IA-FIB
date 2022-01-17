import matplotlib.pyplot as plt

cerodias = [11827, 11828, 11872, 11902, 11897, 11935, 11874, 11699, 11829, 11839, 11770, 11876]
undias = [3980, 3982, 3937, 3895, 3991, 3871, 3972, 4014, 3903, 3894, 3935, 3889]
dosdias = [2977, 2966, 2968, 2875, 2915, 2924, 2892, 3014, 2998, 3015, 3026, 2913]
tresdias = [996, 996, 961, 1038, 933, 972, 966, 954, 1000, 987, 990, 990]

label = ["2", "4", "8", "16", "32", "64", "128", "256", "512", "1024", "2048", "4096"]

x = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]

plt.plot(x, cerodias, marker='o', label="Zero dies pendents")
plt.plot(x, undias, marker='o', label="Un dia pendent")
plt.plot(x, dosdias, marker='o', label="Dos dies pendents")
plt.plot(x, tresdias, marker='o', label="Tres dies pendents")
plt.xticks(x, label)
plt.xlabel("Preu/km")
plt.ylabel("Peticions ateses")
plt.legend()
plt.show()
