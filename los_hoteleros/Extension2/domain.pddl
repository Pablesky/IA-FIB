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
		(evaluat ?reserva - Reserva) ; Ja ha estat evaluat
		(esNord ?reserva - Reserva);de reserva
		(esSud ?reserva - Reserva)
		(esEst ?reserva - Reserva)
		(esOest ?reserva - Reserva)
		(estaNord ?habitacio - Habitacio) ; de habitacio
		(estaSud ?habitacio - Habitacio)
		(estaEst ?habitacio - Habitacio)
		(estaOest ?habitacio - Habitacio)
		(next ?r1 - Reserva ?r2 - Reserva ) ; La següent reserva r2 amb un inici mes gran o igual que el fi r1
		(ready ?r1) ; No té cap reserva amb temps final més petit o igual al temps inicial
	)

	(:functions
		(personesAdmeses ?h - Habitacio);persones admeses en una habitacio
		(diaLLiure ?h - Habitacio)
		(personesReserva ?r - Reserva);persones d'una reserva
		(diaInici ?r - Reserva);dia inici de la reserva
		(diaFi ?r - Reserva);dia final de la reserva
		(cost-reserves);Reserves que encara queden per reservar
		(totalEval);Total de reserves evaluades
		(totalReserves) ;Constant numero de reserves
	)

	(:action assigna
		:parameters (?reserva - Reserva ?reservaNext - Reserva ?habitacio - Habitacio)
		:precondition (and
			(ready ?reserva)
			(not (evaluat ?reserva))
			(next ?reserva ?reservaNext)
			(<= (personesReserva ?reserva) (personesAdmeses ?habitacio))
			(<= (diaLLiure ?habitacio) (diaInici ?reserva))
		)
		:effect (and
			(assign (diaLLiure ?habitacio) (diaFi ?reserva))
			(when
				(not(or
					(and (esEst ?reserva) (estaEst ?habitacio))
					(and (esOest ?reserva) (estaOest ?habitacio))
					(and (esNord ?reserva) (estaNord ?habitacio))
					(and (esSud ?reserva) (estaSud ?habitacio))
				))
			(increase (cost-reserves) 1))

			(evaluat ?reserva)
			(ready ?reservaNext)
			(increase (totalEval) 1)
		)
	)

	(:action no-assignat
		:parameters (?reserva - Reserva ?reservaNext - Reserva)
		:precondition (and (ready ?reserva) (next ?reserva ?reservaNext) (not (evaluat ?reserva)))

		:effect (and
			(increase (cost-reserves) (totalReserves))

			(evaluat ?reserva)
			(ready ?reservaNext)
			(increase (totalEval) 1)
		)
	)
)