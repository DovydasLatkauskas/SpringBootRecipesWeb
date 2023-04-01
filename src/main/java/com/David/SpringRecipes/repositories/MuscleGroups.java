package com.David.SpringRecipes.repositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class MuscleGroups {
    public static Collection<String> getMuscleGroups(){
        return new ArrayList<>(Arrays.asList(
                "abductors",
                "abs",
                "adductors",
                "biceps",
                "calves",
                "cardiovascular system",
                "delts",
                "forearms",
                "glutes",
                "hamstrings",
                "lats",
                "levator scapulae",
                "pectorals",
                "quads",
                "serratus anterior",
                "spine",
                "traps",
                "triceps",
                "upper back"));
    }
}
