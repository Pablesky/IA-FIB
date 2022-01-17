(define (domain miconic)
  (:requirements :adl :typing)
  (:types passenger - object
          going_up going_down vip going_nonstop attendant never_alone
          conflict_A conflict_B - passenger
          floor - object)
  (:predicates
   (origin ?person - passenger ?floor - floor) ;; entry of ?person is ?floor
   (destin ?person - passenger ?floor - floor) ;; exit of ?person is ?floor
   (above ?floor1 - floor  ?floor2 - floor)    ;; ?floor2 is located above of ?floor1
   (boarded ?person - passenger) ;; true if ?person has boarded the lift
   (served ?person - passenger)  ;; true if ?person has alighted as her destination
   (lift-at ?floor - floor)      ;; current position of the lift is at ?floor
   )

  (:action stop
    :parameters (?f - floor)
    :precondition (lift-at ?f)
    :effect (and
	     (forall (?p - passenger)
		     (when (and (boarded ?p)
				(destin ?p ?f))
		       (and (not (boarded ?p))
			    (served  ?p))))
	     (forall (?p - passenger)
		     (when (and (origin ?p ?f) (not (served ?p)))
		       (boarded ?p)))))

  (:action up
    :parameters (?f1 - floor ?f2 - floor)
    :precondition (and (lift-at ?f1) (above ?f1 ?f2))
    :effect (and (lift-at ?f2) (not (lift-at ?f1))))

  (:action down
    :parameters (?f1 - floor ?f2 - floor)
    :precondition (and (lift-at ?f1) (above ?f2 ?f1))
    :effect (and (lift-at ?f2) (not (lift-at ?f1))))
  )

---------------------




(define (problem mixed-f5-p5-u0-v5-d0-a0-n0-A0-B0-N0-F0)
   (:domain miconic)
   (:objects p0 p1 p2 p3 p4 - passenger
             f0 f1 f2 f3 f4 - floor)


(:init
(above f0 f1)
(above f0 f2)
(above f0 f3)
(above f0 f4)

(above f1 f2)
(above f1 f3)
(above f1 f4)

(above f2 f3)
(above f2 f4)

(above f3 f4)



(origin p0 f4)
(destin p0 f1)

(origin p1 f3)
(destin p1 f1)

(origin p2 f3)
(destin p2 f0)

(origin p3 f3)
(destin p3 f2)

(origin p4 f1)
(destin p4 f0)






(lift-at f0)
)


(:goal (forall (?p - passenger) (served ?p)))
)


