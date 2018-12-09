package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.LinkedList;
import java.util.Scanner;

import static java.lang.Math.pow;

public class Main extends Application {

    double foo(double x, LinkedList<Double> coeff){
        return coeff.get(0)*pow(x,3)+coeff.get(1)*pow(x,2)+coeff.get(2)*x+coeff.get(3);
    }

    @Override public void start(Stage stage) {
        stage.setTitle("Polynomial");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("x");
        final LineChart<Number, Number> lineChart =
                new LineChart<Number, Number>(xAxis, yAxis);
        lineChart.setTitle("Drawing polynomial");
        XYChart.Series series = new XYChart.Series();
        series.setName("My data");

        Scanner readme = new Scanner(System. in);
        //System.out.println("Write your coefficients here: ");
        LinkedList<Double> coeff= new LinkedList<>();

        /*for (int i = 0; i < 4; i++){
            coeff.add(readme.nextDouble());
        }*/

        coeff.add(3.0);
        coeff.add(1.0);
        coeff.add(2.0);
        coeff.add(4.0);


        series.getData().add(new XYChart.Data(-1, foo(-1, coeff)));
        series.getData().add(new XYChart.Data(-2, foo(-2, coeff)));
        series.getData().add(new XYChart.Data(-3, foo(-3, coeff)));
        series.getData().add(new XYChart.Data(-4, foo(-4, coeff)));
        series.getData().add(new XYChart.Data(-5, foo(-5, coeff)));
        series.getData().add(new XYChart.Data(-6, foo(-6, coeff)));
        series.getData().add(new XYChart.Data(-7, foo(-7, coeff)));
        series.getData().add(new XYChart.Data(-8, foo(-8, coeff)));
        series.getData().add(new XYChart.Data(-9, foo(-9, coeff)));
        series.getData().add(new XYChart.Data(-10, foo(-10, coeff)));
        series.getData().add(new XYChart.Data(-11, foo(-11, coeff)));
        series.getData().add(new XYChart.Data(-12, foo(-12, coeff)));
        series.getData().add(new XYChart.Data(1, foo(1, coeff)));
        series.getData().add(new XYChart.Data(2, foo(2, coeff)));
        series.getData().add(new XYChart.Data(3, foo(3, coeff)));
        series.getData().add(new XYChart.Data(4, foo(4, coeff)));
        series.getData().add(new XYChart.Data(5, foo(5, coeff)));
        series.getData().add(new XYChart.Data(6, foo(6, coeff)));
        series.getData().add(new XYChart.Data(7, foo(7, coeff)));
        series.getData().add(new XYChart.Data(8, foo(8, coeff)));
        series.getData().add(new XYChart.Data(9, foo(9, coeff)));
        series.getData().add(new XYChart.Data(10, foo(10, coeff)));
        series.getData().add(new XYChart.Data(11, foo(11, coeff)));
        series.getData().add(new XYChart.Data(12, foo(12, coeff)));

        Scene scene = new Scene(lineChart, 800, 600);
        lineChart.getData().add(series);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
