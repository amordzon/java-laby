package org.example;
import java.util.ArrayList;
public class GradeList {
    private ArrayList<Double> grades = new ArrayList<Double>();
    public ArrayList<Double> getGrades(){
        return grades;
    }
    GradeList(){

    }
    public void addGrade(Double grade){
        grades.add(grade);
    }

    public Double calculateAvg(){
        if(grades.size()==0){
            return -1.0;
        }
        Double total = 0.0;
        Double avg = 0.0;
        for(int i=0; i < grades.size(); i++){
            total+=grades.get(i);
        }
        avg = total / grades.size();
        return avg;
    }

    public Double findMax(){
        if(grades.size()==0){
            return -1.0;
        }
        Double max = grades.get(0);
        for(int i = 0; i < grades.size(); i++){
            if(grades.get(i)>max){
                max=grades.get(i);
            }
        }
        return max;
    }

    public Double findMin(){
        if(grades.size()==0){
            return -1.0;
        }
        Double min = grades.get(0);
        for(int i = 0; i < grades.size(); i++){
            if(grades.get(i)<min){
                min=grades.get(i);
            }
        }
        return min;
    }
}
