package com.base.xetaanalyticsassignment;


import android.provider.ContactsContract;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("success")
    private boolean success;
    public Data getData() {
        return data;
    }

    @SerializedName("data")
    private Data data;

    public class Data {

        @SerializedName("section_1")
        private Section1 section_1;
        private Section2 section_2;
        private Section3 section_3;
        private Section4 section_4;

        public Section1 getSection_1() {
            return section_1;
        }

        public Section2 getSection_2() {
            return section_2;
        }

        public Section3 getSection_3() {
            return section_3;
        }

        public Section4 getSection_4() {
            return section_4;
        }
// getters and setters
    }

    public class Section1 {
        @SerializedName("plan_name")
        private String plan_name;
        private String progress;

        // getters and setters

        public String getPlan_name() {
            return plan_name;
        }

        public String getProgress() {
            return progress;
        }
    }

    public class Section2 {
        private String accuracy;
        private String workout_duration;
        private String reps;
        private String calories_burned;

        // getters and setters

        public String getAccuracy() {
            return accuracy;
        }

        public String getWorkout_duration() {
            return workout_duration;
        }

        public String getReps() {
            return reps;
        }

        public String getCalories_burned() {
            return calories_burned;
        }
    }

    public class Section3 {
        private Plan plan_1;
        private Plan plan_2;

        public Plan getPlan_1() {
            return plan_1;
        }

        public Plan getPlan_2() {
            return plan_2;
        }
// getters and setters
    }

    public class Section4 {
        private Category category_1;
        private Category category_2;

        public Category getCategory_1() {
            return category_1;
        }

        public Category getCategory_2() {
            return category_2;
        }
// getters and setters
    }

    public class Plan {
        private String plan_name;
        private String difficulty;

        public String getPlan_name() {
            return plan_name;
        }

        public String getDifficulty() {
            return difficulty;
        }
// getters and setters
    }

    public class Category {
        private String category_name;
        private String no_of_exercises;

        public String getCategory_name() {
            return category_name;
        }

        public String getNo_of_exercises() {
            return no_of_exercises;
        }
// getters and setters
    }


}