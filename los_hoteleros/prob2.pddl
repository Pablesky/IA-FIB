(define (problem p2base) (:domain hoteleros)(:objects a0 a1 a2 a3 a4 a5  - Habitacio ;instacies d'habitacio
r0 r1 r2 r3 r4 r5 r6 r7 r8 r9 r10 r11 r12 r13 r14 r15 r16 r17 r18 r19 r20 r21 r22 r23 r24 r25 r26 r27 r28 r29 r30 r31 r32 r33 r34 r35 r36 r37 r38 r39 r40 r41 r42 r43 r44 r45 r46 r47 r48 r49 r50 r51 r52 r53 r54 r55 r56 r57 r58 r59 r60 r61 r62 r63 r64 r65 r66 r67 r68 r69 r70 r71 r72 r73 r74 r75 r76 r77 r78 r79 r80 r81 r82 r83 r84 r85 r86 r87 r88 r89 r90 r91 r92 r93 r94 r95 r96 r97 r98 r99  - Reserva ;instacies de reserva
)(:init
(= (personesAdmeses a0) 4)(= (diaLLiure a0) 0)
(estaOest a0)
(= (personesAdmeses a1) 1)(= (diaLLiure a1) 0)
(estaOest a1)
(= (personesAdmeses a2) 1)(= (diaLLiure a2) 0)
(estaOest a2)
(= (personesAdmeses a3) 1)(= (diaLLiure a3) 0)
(estaSud a3)
(= (personesAdmeses a4) 2)(= (diaLLiure a4) 0)
(estaOest a4)
(= (personesAdmeses a5) 1)(= (diaLLiure a5) 0)
(estaOest a5)
(=(personesReserva r0) 3)(=(diaInici r0) 2)(=(diaFi r0) 3)
(esNord r0)
(ready r0)
(next r0 r1)
(=(personesReserva r1) 2)(=(diaInici r1) 2)(=(diaFi r1) 7)
(esSud r1)
(next r1 r2)
(=(personesReserva r2) 4)(=(diaInici r2) 6)(=(diaFi r2) 7)
(esEst r2)
(next r2 r3)
(=(personesReserva r3) 1)(=(diaInici r3) 3)(=(diaFi r3) 9)
(esOest r3)
(next r3 r4)
(=(personesReserva r4) 4)(=(diaInici r4) 8)(=(diaFi r4) 9)
(esOest r4)
(next r4 r5)
(=(personesReserva r5) 3)(=(diaInici r5) 3)(=(diaFi r5) 10)
(esEst r5)
(next r5 r6)
(=(personesReserva r6) 3)(=(diaInici r6) 5)(=(diaFi r6) 10)
(esNord r6)
(next r6 r7)
(=(personesReserva r7) 4)(=(diaInici r7) 9)(=(diaFi r7) 10)
(esNord r7)
(next r7 r8)
(=(personesReserva r8) 1)(=(diaInici r8) 3)(=(diaFi r8) 11)
(esSud r8)
(next r8 r9)
(=(personesReserva r9) 3)(=(diaInici r9) 9)(=(diaFi r9) 11)
(esEst r9)
(next r9 r10)
(=(personesReserva r10) 2)(=(diaInici r10) 11)(=(diaFi r10) 12)
(esOest r10)
(next r10 r11)
(=(personesReserva r11) 1)(=(diaInici r11) 2)(=(diaFi r11) 13)
(esNord r11)
(next r11 r12)
(=(personesReserva r12) 2)(=(diaInici r12) 4)(=(diaFi r12) 13)
(esNord r12)
(next r12 r13)
(=(personesReserva r13) 2)(=(diaInici r13) 7)(=(diaFi r13) 13)
(esSud r13)
(next r13 r14)
(=(personesReserva r14) 1)(=(diaInici r14) 12)(=(diaFi r14) 13)
(esEst r14)
(next r14 r15)
(=(personesReserva r15) 3)(=(diaInici r15) 2)(=(diaFi r15) 14)
(esSud r15)
(next r15 r16)
(=(personesReserva r16) 3)(=(diaInici r16) 3)(=(diaFi r16) 14)
(esEst r16)
(next r16 r17)
(=(personesReserva r17) 4)(=(diaInici r17) 6)(=(diaFi r17) 14)
(esSud r17)
(next r17 r18)
(=(personesReserva r18) 2)(=(diaInici r18) 9)(=(diaFi r18) 14)
(esSud r18)
(next r18 r19)
(=(personesReserva r19) 1)(=(diaInici r19) 10)(=(diaFi r19) 14)
(esSud r19)
(next r19 r20)
(=(personesReserva r20) 3)(=(diaInici r20) 5)(=(diaFi r20) 15)
(esOest r20)
(next r20 r21)
(=(personesReserva r21) 1)(=(diaInici r21) 6)(=(diaFi r21) 15)
(esNord r21)
(next r21 r22)
(=(personesReserva r22) 3)(=(diaInici r22) 7)(=(diaFi r22) 15)
(esNord r22)
(next r22 r23)
(=(personesReserva r23) 3)(=(diaInici r23) 7)(=(diaFi r23) 15)
(esSud r23)
(next r23 r24)
(=(personesReserva r24) 3)(=(diaInici r24) 11)(=(diaFi r24) 15)
(esSud r24)
(next r24 r25)
(=(personesReserva r25) 2)(=(diaInici r25) 2)(=(diaFi r25) 16)
(esEst r25)
(next r25 r26)
(=(personesReserva r26) 2)(=(diaInici r26) 4)(=(diaFi r26) 16)
(esOest r26)
(next r26 r27)
(=(personesReserva r27) 4)(=(diaInici r27) 5)(=(diaFi r27) 16)
(esNord r27)
(next r27 r28)
(=(personesReserva r28) 2)(=(diaInici r28) 10)(=(diaFi r28) 16)
(esEst r28)
(next r28 r29)
(=(personesReserva r29) 3)(=(diaInici r29) 15)(=(diaFi r29) 16)
(esNord r29)
(next r29 r30)
(=(personesReserva r30) 3)(=(diaInici r30) 4)(=(diaFi r30) 17)
(esEst r30)
(next r30 r31)
(=(personesReserva r31) 4)(=(diaInici r31) 4)(=(diaFi r31) 17)
(esEst r31)
(next r31 r32)
(=(personesReserva r32) 4)(=(diaInici r32) 4)(=(diaFi r32) 17)
(esEst r32)
(next r32 r33)
(=(personesReserva r33) 3)(=(diaInici r33) 8)(=(diaFi r33) 17)
(esOest r33)
(next r33 r34)
(=(personesReserva r34) 4)(=(diaInici r34) 9)(=(diaFi r34) 17)
(esNord r34)
(next r34 r35)
(=(personesReserva r35) 1)(=(diaInici r35) 9)(=(diaFi r35) 17)
(esEst r35)
(next r35 r36)
(=(personesReserva r36) 4)(=(diaInici r36) 10)(=(diaFi r36) 17)
(esOest r36)
(next r36 r37)
(=(personesReserva r37) 2)(=(diaInici r37) 5)(=(diaFi r37) 18)
(esSud r37)
(next r37 r38)
(=(personesReserva r38) 2)(=(diaInici r38) 5)(=(diaFi r38) 18)
(esOest r38)
(next r38 r39)
(=(personesReserva r39) 3)(=(diaInici r39) 12)(=(diaFi r39) 18)
(esEst r39)
(next r39 r40)
(=(personesReserva r40) 3)(=(diaInici r40) 13)(=(diaFi r40) 18)
(esSud r40)
(next r40 r41)
(=(personesReserva r41) 4)(=(diaInici r41) 5)(=(diaFi r41) 19)
(esNord r41)
(next r41 r42)
(=(personesReserva r42) 4)(=(diaInici r42) 13)(=(diaFi r42) 19)
(esEst r42)
(next r42 r43)
(=(personesReserva r43) 3)(=(diaInici r43) 15)(=(diaFi r43) 20)
(esEst r43)
(next r43 r44)
(=(personesReserva r44) 1)(=(diaInici r44) 18)(=(diaFi r44) 20)
(esEst r44)
(next r44 r45)
(=(personesReserva r45) 1)(=(diaInici r45) 12)(=(diaFi r45) 21)
(esOest r45)
(next r45 r46)
(=(personesReserva r46) 2)(=(diaInici r46) 18)(=(diaFi r46) 21)
(esNord r46)
(next r46 r47)
(=(personesReserva r47) 3)(=(diaInici r47) 19)(=(diaFi r47) 21)
(esNord r47)
(next r47 r48)
(=(personesReserva r48) 4)(=(diaInici r48) 8)(=(diaFi r48) 22)
(esSud r48)
(next r48 r49)
(=(personesReserva r49) 2)(=(diaInici r49) 11)(=(diaFi r49) 22)
(esSud r49)
(next r49 r50)
(=(personesReserva r50) 1)(=(diaInici r50) 11)(=(diaFi r50) 22)
(esNord r50)
(next r50 r51)
(=(personesReserva r51) 3)(=(diaInici r51) 15)(=(diaFi r51) 22)
(esOest r51)
(next r51 r52)
(=(personesReserva r52) 1)(=(diaInici r52) 19)(=(diaFi r52) 22)
(esOest r52)
(next r52 r53)
(=(personesReserva r53) 3)(=(diaInici r53) 9)(=(diaFi r53) 23)
(esEst r53)
(next r53 r54)
(=(personesReserva r54) 3)(=(diaInici r54) 20)(=(diaFi r54) 23)
(esSud r54)
(next r54 r55)
(=(personesReserva r55) 3)(=(diaInici r55) 13)(=(diaFi r55) 24)
(esEst r55)
(next r55 r56)
(=(personesReserva r56) 2)(=(diaInici r56) 12)(=(diaFi r56) 25)
(esEst r56)
(next r56 r57)
(=(personesReserva r57) 4)(=(diaInici r57) 14)(=(diaFi r57) 25)
(esOest r57)
(next r57 r58)
(=(personesReserva r58) 3)(=(diaInici r58) 15)(=(diaFi r58) 25)
(esSud r58)
(next r58 r59)
(=(personesReserva r59) 3)(=(diaInici r59) 15)(=(diaFi r59) 25)
(esNord r59)
(next r59 r60)
(=(personesReserva r60) 2)(=(diaInici r60) 24)(=(diaFi r60) 25)
(esNord r60)
(next r60 r61)
(=(personesReserva r61) 4)(=(diaInici r61) 19)(=(diaFi r61) 26)
(esEst r61)
(next r61 r62)
(=(personesReserva r62) 4)(=(diaInici r62) 22)(=(diaFi r62) 26)
(esSud r62)
(next r62 r63)
(=(personesReserva r63) 3)(=(diaInici r63) 13)(=(diaFi r63) 27)
(esEst r63)
(next r63 r64)
(=(personesReserva r64) 4)(=(diaInici r64) 17)(=(diaFi r64) 27)
(esSud r64)
(next r64 r65)
(=(personesReserva r65) 4)(=(diaInici r65) 17)(=(diaFi r65) 27)
(esSud r65)
(next r65 r66)
(=(personesReserva r66) 2)(=(diaInici r66) 19)(=(diaFi r66) 27)
(esSud r66)
(next r66 r67)
(=(personesReserva r67) 2)(=(diaInici r67) 20)(=(diaFi r67) 27)
(esNord r67)
(next r67 r68)
(=(personesReserva r68) 4)(=(diaInici r68) 22)(=(diaFi r68) 27)
(esNord r68)
(next r68 r69)
(=(personesReserva r69) 1)(=(diaInici r69) 23)(=(diaFi r69) 27)
(esNord r69)
(next r69 r70)
(=(personesReserva r70) 3)(=(diaInici r70) 23)(=(diaFi r70) 27)
(esNord r70)
(next r70 r71)
(=(personesReserva r71) 4)(=(diaInici r71) 25)(=(diaFi r71) 27)
(esEst r71)
(next r71 r72)
(=(personesReserva r72) 1)(=(diaInici r72) 25)(=(diaFi r72) 27)
(esEst r72)
(next r72 r73)
(=(personesReserva r73) 1)(=(diaInici r73) 19)(=(diaFi r73) 28)
(esOest r73)
(next r73 r74)
(=(personesReserva r74) 1)(=(diaInici r74) 23)(=(diaFi r74) 28)
(esNord r74)
(next r74 r75)
(=(personesReserva r75) 4)(=(diaInici r75) 25)(=(diaFi r75) 28)
(esEst r75)
(next r75 r76)
(=(personesReserva r76) 4)(=(diaInici r76) 26)(=(diaFi r76) 28)
(esNord r76)
(next r76 r77)
(=(personesReserva r77) 3)(=(diaInici r77) 26)(=(diaFi r77) 28)
(esSud r77)
(next r77 r78)
(=(personesReserva r78) 4)(=(diaInici r78) 27)(=(diaFi r78) 28)
(esOest r78)
(next r78 r79)
(=(personesReserva r79) 3)(=(diaInici r79) 16)(=(diaFi r79) 29)
(esOest r79)
(next r79 r80)
(=(personesReserva r80) 2)(=(diaInici r80) 19)(=(diaFi r80) 29)
(esNord r80)
(next r80 r81)
(=(personesReserva r81) 2)(=(diaInici r81) 22)(=(diaFi r81) 29)
(esEst r81)
(next r81 r82)
(=(personesReserva r82) 4)(=(diaInici r82) 26)(=(diaFi r82) 29)
(esNord r82)
(next r82 r83)
(=(personesReserva r83) 2)(=(diaInici r83) 27)(=(diaFi r83) 29)
(esSud r83)
(next r83 r84)
(=(personesReserva r84) 1)(=(diaInici r84) 28)(=(diaFi r84) 29)
(esEst r84)
(next r84 r85)
(=(personesReserva r85) 3)(=(diaInici r85) 28)(=(diaFi r85) 29)
(esNord r85)
(next r85 r86)
(=(personesReserva r86) 3)(=(diaInici r86) 16)(=(diaFi r86) 30)
(esEst r86)
(next r86 r87)
(=(personesReserva r87) 4)(=(diaInici r87) 17)(=(diaFi r87) 30)
(esSud r87)
(next r87 r88)
(=(personesReserva r88) 3)(=(diaInici r88) 18)(=(diaFi r88) 30)
(esNord r88)
(next r88 r89)
(=(personesReserva r89) 1)(=(diaInici r89) 21)(=(diaFi r89) 30)
(esEst r89)
(next r89 r90)
(=(personesReserva r90) 2)(=(diaInici r90) 22)(=(diaFi r90) 30)
(esEst r90)
(next r90 r91)
(=(personesReserva r91) 2)(=(diaInici r91) 24)(=(diaFi r91) 30)
(esOest r91)
(next r91 r92)
(=(personesReserva r92) 3)(=(diaInici r92) 25)(=(diaFi r92) 30)
(esNord r92)
(next r92 r93)
(=(personesReserva r93) 3)(=(diaInici r93) 26)(=(diaFi r93) 30)
(esNord r93)
(next r93 r94)
(=(personesReserva r94) 4)(=(diaInici r94) 26)(=(diaFi r94) 30)
(esNord r94)
(next r94 r95)
(=(personesReserva r95) 2)(=(diaInici r95) 27)(=(diaFi r95) 30)
(esNord r95)
(next r95 r96)
(=(personesReserva r96) 2)(=(diaInici r96) 27)(=(diaFi r96) 30)
(esSud r96)
(next r96 r97)
(=(personesReserva r97) 4)(=(diaInici r97) 27)(=(diaFi r97) 30)
(esOest r97)
(next r97 r98)
(=(personesReserva r98) 3)(=(diaInici r98) 28)(=(diaFi r98) 30)
(esNord r98)
(next r98 r99)
(=(personesReserva r99) 2)(=(diaInici r99) 29)(=(diaFi r99) 30)
(esOest r99)
(next r99 r0)
(=(cost-reserves) 0)(=(totalEval) 0)(=(totalReserves) 100))
(:goal(=(totalEval) 100))(:metric minimize (cost-reserves)))
