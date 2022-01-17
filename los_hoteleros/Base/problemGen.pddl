(define (problem p1base) (:domain hoteleros)
(:objects
a0  - Habitacio ;instacies d'habitacio
r0  - Reserva ;instacies de reserva
)
(:init
(= (personesAdmeses a0) 4)
(= (personesReserva r0) 1) (= (diaInici r0) 4) (= (diaFi r0) 5))

(:goal
	(forall
		(?r - Reserva)
		(exists
			(?h - Habitacio)
			(assignacio ?r ?h)
		)
	)
))
