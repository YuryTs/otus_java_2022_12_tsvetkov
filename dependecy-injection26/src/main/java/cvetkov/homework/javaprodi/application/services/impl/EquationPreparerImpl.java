package cvetkov.homework.javaprodi.application.services.impl;

import cvetkov.homework.javaprodi.application.model.DivisionEquation;
import cvetkov.homework.javaprodi.application.model.Equation;
import cvetkov.homework.javaprodi.application.model.MultiplicationEquation;
import cvetkov.homework.javaprodi.application.services.EquationPreparer;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class EquationPreparerImpl implements EquationPreparer {

    @Override
    public List<Equation> prepareEquationsFor(int base) {
        List<Equation> equations = new ArrayList<>();
        for (int i = 1; i < 2; i++) {
            MultiplicationEquation multiplicationEquation = new MultiplicationEquation(base, i);
            DivisionEquation divisionEquation = new DivisionEquation(multiplicationEquation.getResult(), base);
            equations.add(multiplicationEquation);
            equations.add(divisionEquation);

        }
        Collections.shuffle(equations);
        return equations;
    }
}
