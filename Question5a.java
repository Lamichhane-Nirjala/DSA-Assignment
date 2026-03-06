import javax.swing.*;
import java.awt.*;
import java.util.*;

class TouristSpot {

    String name;
    double lat, lon;
    int entryFee;
    String tag;

    TouristSpot(String name,double lat,double lon,int fee,String tag){
        this.name=name;
        this.lat=lat;
        this.lon=lon;
        this.entryFee=fee;
        this.tag=tag;
    }
}

public class Question5A extends JFrame {

    JTextField budgetField;
    JTextField interestField;
    JTextArea resultArea;

    ArrayList<TouristSpot> spots=new ArrayList<>();

    public Question5A(){

        setTitle("Tourist Spot Optimizer");
        setSize(400,400);
        setLayout(new FlowLayout());

        add(new JLabel("Budget:"));
        budgetField=new JTextField(10);
        add(budgetField);

        add(new JLabel("Interest:"));
        interestField=new JTextField(10);
        add(interestField);

        JButton button=new JButton("Generate Plan");
        add(button);

        resultArea=new JTextArea(10,30);
        add(resultArea);

        // sample data
        spots.add(new TouristSpot("Pashupatinath",27.71,85.34,100,"culture"));
        spots.add(new TouristSpot("Swayambhunath",27.71,85.29,200,"heritage"));
        spots.add(new TouristSpot("Garden of Dreams",27.71,85.31,150,"nature"));

        button.addActionListener(e -> generatePlan());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    void generatePlan(){

        int budget=Integer.parseInt(budgetField.getText());
        String interest=interestField.getText();

        resultArea.setText("");

        for(TouristSpot s:spots){

            if(s.entryFee<=budget && s.tag.contains(interest)){
                resultArea.append(s.name+"\n");
                budget-=s.entryFee;
            }
        }
    }

    public static void main(String[] args){
        new Question5A();
    }
}