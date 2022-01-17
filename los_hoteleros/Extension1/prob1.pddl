(define (problem p1base) (:domain hoteleros)
(:objects
	a1 - Habitacio ;instacies d'habitacio
	r1 r2 r3 - Reserva ;instacies de reserva
)

(:init
	(= (personesAdmeses a1) 2)
	(= (diaLLiure a1) 0)
	(= (personesReserva r1) 1)
	(= (diaInici r1) 10)
	(= (diaFi r1) 20)
	(next r1 r3)
	(= (personesReserva r2) 1)
	(= (diaInici r2) 5)
	(= (diaFi r2) 15)
	(next r2 r1)
	(= (personesReserva r3) 1)
	(= (diaInici r3) 1)
	(= (diaFi r3) 10)
	(next r3 r2)
	(ready r1)
	(= (cost-reserves) 0)
	(= (totalEval) 0)
)

(:goal
	(= (totalEval) 3)
)
(:metric minimize (cost-reserves))
)
