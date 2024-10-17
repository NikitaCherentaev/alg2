import java.util.Random;

public class Main {
    static final int ARRAY_SIZE = 1000; //размер массива

    public static void main(String[] args) {
        int[] nums = new int[ARRAY_SIZE]; //массив для чисел

        //экземпляр класса генерации случайных чисел
        Random random = new Random();


        //заполняем массив случайными числами от 0 до 999
        for (int i = 0; i < ARRAY_SIZE; i++) { //цикл от 0 до 999.
            nums[i] = random.nextInt(10001); //добавление случайных чисел(0..10000) в массив
        }

        //объявление и инициализация переменных для хранения минимальных чисел
        int minMultipleThree = Integer.MAX_VALUE; //мин. число, кратное 3
        int minMultipleSeven = Integer.MAX_VALUE; //мин. число, кратное 7
        int minMultipleTwentyOne = Integer.MAX_VALUE; //мин. число, кратное 21
        int minNonMultiple = Integer.MAX_VALUE; //мин. число, не кратное 3, 7 и 21

        //проход по массиву
        for (int i = 0; i < ARRAY_SIZE; i++) {
            if (nums[i] % 21 == 0 && nums[i] < minMultipleTwentyOne) { //проверяем кратно ли число 21 и меньше ли текущего значения minMultipleTwentyOne
                minMultipleTwentyOne = nums[i]; //если да, то обновление его
            } else if (nums[i] % 3 == 0 && nums[i] < minMultipleThree) { //проверяем кратно ли число 3 и меньше ли текущего значения minMultipleThree
                minMultipleThree = nums[i]; //если да, то обновляем его
            } else if (nums[i] % 7 == 0 && nums[i] < minMultipleSeven) { //проверяем кратно ли число 7 и меньше ли текущего значения minMultipleSeven
                minMultipleSeven = nums[i]; //если да, то обновляем его
            } else if (nums[i] < minNonMultiple) { //обновляем минимальное, не кратное ни одному из чисел 7, 3, 21 число, если оно меньше текущего
                minNonMultiple = nums[i];
            }
        }

        int resultOfMultiplyOfMinMultipleThreeAndSeven = 0; //переменная для результата произведения мин. числа кратного 3 и 7
        int resultOfMultiplyOfMinNonMultipleAndMultipleOfTwentyOne = 0; //переменная для результата произведения минимального(не кратного) числа и числа кратного 21

        if (minMultipleThree != Integer.MAX_VALUE && minMultipleSeven != Integer.MAX_VALUE) { //проверяем были ли найдены минимальные числа
            resultOfMultiplyOfMinMultipleThreeAndSeven = minMultipleThree * minMultipleSeven; //если да, то вычисляем их произведение
        }

        if (minMultipleTwentyOne != Integer.MAX_VALUE) { //проверяем найдено ли минимальное число кратное 21
            //если да, то вычисляем произведение minMultipleTwentyOne и самого малого среди minMultipleThree, minMultipleSeven и minNonMultiple
            resultOfMultiplyOfMinNonMultipleAndMultipleOfTwentyOne = minMultipleTwentyOne * Math.min(minMultipleThree, Math.min(minMultipleSeven, minNonMultiple));
        }

        //определяем минимальный результат произведений
        int result = Math.min(resultOfMultiplyOfMinMultipleThreeAndSeven, resultOfMultiplyOfMinNonMultipleAndMultipleOfTwentyOne);

        //выводим результат или -1, если он не был получен
        if (result != -1) {
            System.out.println("минимальное число кратное 21, являющееся при этом произведением 2 других чисел из массива: " + result);
        } else {
            System.out.println(-1);
        }
    }
}