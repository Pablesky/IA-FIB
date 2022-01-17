from random import seed
from random import randint

import sys

def main():
    print(sys.argv)
    if len(sys.argv) == 4:
        seed(int(sys.argv[1]))
        numeroHabitacions = int(sys.argv[2])
        numeroReserves = int(sys.argv[3])
        with open("problemGen.pddl", "w+", encoding = 'utf-8') as f:
            f.write("(define (problem p1base) (:domain hoteleros)")
            f.write("(:objects ")
            for i in range(0, numeroHabitacions):
                f.write("a{} ".format(i))
            f.write(" - Habitacio ;instacies d'habitacio\n")
            for i in range(0, numeroReserves):
                f.write("r{} ".format(i))
            f.write(" - Reserva ;instacies de reserva\n")
            f.write(")")
            f.write("(:init ")
            for i in range(0, numeroHabitacions):
                f.write("(= (personesAdmeses a{a}) {b})(= (diaLLiure a{a}) 0)\n".format(a=i, b=randint(1,4)))

            dies = []
            for i in range(0, numeroReserves):
                diaInici = randint(1, 29)
                diaFinal = randint(1, 30)

                while diaInici >= diaFinal or diaFinal - diaInici > 14:# A nice size of days
                    diaFinal = randint(1, 30)

                dies.append((diaInici, diaFinal))
            dies.sort(key=lambda tup: (tup[1],tup[0]))
            for i in range(0, numeroReserves):
                f.write("(=(personesReserva r{r}) {persones})(=(diaInici r{r}) {inici})(=(diaFi r{r}) {fi})".
                    format(r=i, persones=randint(1,4), inici=dies[i][0], fi=dies[i][1]))
                if i == 0:
                    f.write("(ready r{})".format(i))
                if i != numeroReserves-1:
                    f.write("(next r{} r{})\n".format(i, i+1))
                else:
                    f.write("(next r{} r{})\n".format(i, 0))

            f.write("(=(cost-reserves) 0)(=(totalEval) 0))")
            f.write(
"""
(:goal(=(totalEval) {}))(:metric minimize (cost-reserves)))
""".format(numeroReserves)
            )

    else:
        print("No has introduit cap valor al sistema, introdueix la seed del generador random, el numero d'habitacion, el numero de reserves")

if __name__ == '__main__':
	main()