(define (problem p1base) (:domain hoteleros)
(:objects
	a1 - Habitacio ;instacies d'habitacio
	r1 r2 - Reserva ;instacies de reserva
)

(:init
	(= (personesAdmeses a1) 2)
	(= (personesReserva r1) 1)
	(= (diaInici r1) 1)
	(= (diaFi r1) 10)
	(= (personesReserva r2) 2)
	(= (diaInici r2) 11)
	(= (diaFi r2) 20)
)

(:goal
	(forall
		(?r - Reserva)
		(exists
			(?h - Habitacio)
			(assignacio ?r ?h)
		)
	)
)

;un-comment the following line if metric is needed
;(:metric minimize (???))
)
