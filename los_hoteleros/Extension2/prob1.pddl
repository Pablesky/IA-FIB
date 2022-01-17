(define (problem p1base) (:domain hoteleros)(:objects a0  - Habitacio ;instacies d'habitacio
r0 r1 r2  - Reserva ;instacies de reserva
)(:init
(= (personesAdmeses a0) 4)(= (diaLLiure a0) 0)
(estaOest a0)
(=(personesReserva r0) 1)(=(diaInici r0) 1)(=(diaFi r0) 3)
(esEst r0)
(ready r0)
(next r0 r1)
(=(personesReserva r1) 1)(=(diaInici r1) 1)(=(diaFi r1) 8)
(esOest r1)
(next r1 r2)
(=(personesReserva r2) 1)(=(diaInici r2) 26)(=(diaFi r2) 28)
(esSud r2)
(next r2 r0)
(=(cost-reserves) 0)(=(totalEval) 0)(=(totalReserves) 3))
(:goal(=(totalEval) 3))(:metric minimize (cost-reserves)))
