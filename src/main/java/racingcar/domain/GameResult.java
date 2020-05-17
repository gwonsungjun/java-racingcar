package racingcar.domain;

import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class GameResult {
    private static final String OUTPUT_CHARACTERS = "-";

    private final List<Car> cars;

    public GameResult(List<Car> cars) {
        this.cars = cars;
    }

    public List<String> getResult() {
        return cars.stream().map(car -> {
            int carPosition = car.getPosition();
            String carName = car.getName();
            return carName.concat(" : ").concat(replacePositionToOutputCharacters(carPosition));
        }).collect(Collectors.toList());
    }

    private String replacePositionToOutputCharacters(int carPosition) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < carPosition; i++) {
            sb.append(OUTPUT_CHARACTERS);
        }

        return sb.toString();
    }

    public void displayResult() {
        OutputView.printOut(this);
    }

    public static void displayWinner(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(","));
        
        OutputView.printOutWinner(winnerNames);
    }
}
