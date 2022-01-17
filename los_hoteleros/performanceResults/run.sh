#!/bin/bash

for hab in {1..10}; do
	for solIt in {1..10}; do
		sol=$(( 10*solIt ))
		python generator.py 1234 $hab $sol
		mv problemGen.pddl problem.$hab.$sol.pddl
		timeout 10m ./executar.sh problem.$hab.$sol.pddl | tee result.$hab.$sol.txt
	done
done

rm problem.*.pddl