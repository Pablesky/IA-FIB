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
            f.write("(define (problem p1base) (:domain hoteleros)\n")
            f.write("(:objects\n")
            for i in range(0, numeroHabitacions):
                f.write("a{} ".format(i))
            f.write(" - Habitacio ;instacies d'habitacio\n")
            for i in range(0, numeroReserves):
                f.write("r{} ".format(i))
            f.write(" - Reserva ;instacies de reserva\n")
            f.write(")\n")
            f.write("(:init\n")
            for i in range(0, numeroHabitacions):
                f.write("(= (personesAdmeses a{a}) {b})\n".format(a=i, b=randint(1,4)))
            for i in range(0, numeroReserves):
                diaInici = randint(1, 29)
                diaFinal = min(30, diaInici + randint(1, 30))

                f.write("(= (personesReserva r{r}) {persones}) (= (diaInici r{r}) {inici}) (= (diaFi r{r}) {fi})".
                    format(r=i, persones=randint(1,4), inici=diaInici, fi=diaFinal))
            f.write(")\n")
            f.write(
"""
(:goal
	(forall
		(?r - Reserva)
		(exists
			(?h - Habitacio)
			(assignacio ?r ?h)
		)
	)
))
"""
            )

    else:
        print("No has introduit cap valor al sistema, introdueix la seed del generador random, el numero d'habitacion, el numero de reserves")

if __name__ == '__main__':
	main()