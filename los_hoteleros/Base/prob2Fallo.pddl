(define (problem p1base) (:domain hoteleros)
(:objects
	a1 - Habitacio ;instacies d'habitacio
	r1 - Reserva ;instacies de reserva
)

(:init
	(= (personesAdmeses a1) 1)
	(= (personesReserva r1) 2)
	(= (diaInici r1) 1)
	(= (diaFi r1) 10)
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
