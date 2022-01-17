(
	define (domain hoteleros)

	(:requirements :adl :strips :fluents :typing :equality)

	(:types
		Habitacio - object
		Reserva - object
	)

	; un-comment following line if constants are needed
	;(:constants )

	(:predicates
		(assignacio ?reserva - Reserva ?habitacio - Habitacio) ;assigancio de la reserva a una habitacio
	)

	(:functions
		(personesAdmeses ?h - Habitacio);persones admeses en una habitacio
		(personesReserva ?r - Reserva);persones d'una reserva
		(diaInici ?r - Reserva);dia inici de la reserva
		(diaFi ?r - Reserva);dia final de la reserva
	)

	(:action ferReserva
		:parameters (?reserva - Reserva ?habitacio - Habitacio)
		:precondition (and
			(
				<= (personesReserva ?reserva) (personesAdmeses ?habitacio)
			)
			(not (exists (?otraHabitacio - Habitacio) (assignacio ?reserva ?otraHabitacio)))
			(forall (?otraReserva - Reserva)
				(imply
					(assignacio ?otraReserva ?habitacio)
					(or (<= (diaFi ?reserva) (diaInici ?otraReserva))
						(>= (diaInici ?reserva) (diaFi ?otraReserva))
					)
				)
			)
		)
		:effect (assignacio ?reserva ?habitacio)
	)

)