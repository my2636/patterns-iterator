import java.util.Iterator;
import java.util.Random;

/**
 * Нужно написать класс, расширяющий Iterable<Integer>, по которому мы будем итерироваться.
 * В процессе итерирования мы будем от него получать случайные числа в диапазоне значений.
 * Диапазон задаётся двумя числами - минимальным и максимальным значениями. Передаются они через параметры конструктора.
 * Таким образом, итератор по объектам нашего класса будет итерироваться по бесконечной последовательности из случайных чисел в заданом интервале:
 */
/*


- Создайте класс Randoms, скопируйте его заготовку из кода выше.
- Реализуйте требуемый интерфейсом Iterable метод, для чего вам может понадобиться создать вспомогательный класс для итератора (реализующего Iterator<Integer>) по вашему классу.
- Для генерации случайных чисел используйте встроенный класс Random.
- Создайте класс Main, продемонстрируйте работосбособность написанного вами класса, например как это было сделано выше.
- Протестируйте работу программы. Не забывайте про правила форматирования кода (для автоформата можете выделить код в идее и нажать Ctrl+Alt+L).
*/


class Randoms implements Iterable<Integer> {
    protected Random random;
    int min;
    int max;


    public Randoms(int min, int max) {
        this.min = min;
        this.max = max;
        this.random = new Random();
    }


    @Override
    public Iterator<Integer> iterator() {
        return new RandomIntegerIterator();
    }

    private class RandomIntegerIterator implements Iterator<Integer> {

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Integer next() {

            return min + random.nextInt(max - min + 1);
        }
    }
}