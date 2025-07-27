package dev.guisandroni.Design_patterns_dio.strategy;

import dev.guisandroni.Design_patterns_dio.model.Tutor;

import java.util.List;

public class FilterTutorStrategy {

    public List<Tutor> filter(List<Tutor> tutors, String value){
        return tutors ;
    }
}
