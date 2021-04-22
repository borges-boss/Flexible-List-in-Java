package list;

public class List<T> {

    private class Cell<T> {

        private Object element;
        private Cell prox;

        public Cell() {
            this.element = null;
        }

        public Cell(Object element) {
            this.element = (T) element;
            this.prox = null;
        }

        public void setElement(Object element) {
            this.element = (T) element;
        }

        public T getElement() {
            return (T) element;
        }

        public void setNext(Cell c) {
            this.prox = c;
        }

        public Cell getNext() {
            return this.prox;
        }

    }

    private Cell< T> primeiro,
            ultimo;
    private int size = 0;

    public List() {
        primeiro = new Cell();
        ultimo = primeiro;
    }

    public int size() {
        return size;
    }

    public void add(Object value) { //final
        ultimo.setNext(new Cell(value));
        ultimo = ultimo.getNext();
        size++;
    }

    public void addAtStart(Object value) {
        Cell tmp = primeiro.getNext();

        primeiro.setNext(new Cell(value));
        primeiro.getNext().setNext(tmp);
        size++;
    }

    public void add(int index, Object value) {

        Cell tmp = primeiro.getNext();
        Cell ant = tmp;
        int count = 0;

        while (tmp != null) {

            if (index == count) {
                Cell cell = new Cell(value);
                cell.setNext(tmp);
                ant.setNext(cell);
                size++;
                break;
            }

            ant = tmp;
            tmp = tmp.getNext();
            count++;
        }

    }

    public void set(int index, Object value) {

        Cell tmp = primeiro.getNext();
        int count = 0;

        while (tmp != null) {

            if (index == count) {
                tmp.setElement(value);
                break;
            }

            tmp = tmp.getNext();
            count++;
        }

    }

    public T get(int index) {

        int count = 0;
        Cell tmp = primeiro.getNext();
        Object value = null;

        while (tmp != null) {

            if (count == index) {
                value = (T) tmp.getElement();
                return (T) value;
            }

            tmp = tmp.getNext();
            count++;
        }

        return (T) value;
    }

    public T remove(int index) {

        Cell tmp = primeiro;
        Object itemRemoved = null;

        if (index == 0 && tmp.getNext() != null) {
            itemRemoved = (T) tmp.getNext().getElement();
            tmp.setNext(tmp.getNext().getNext());
            size--;
            return (T) itemRemoved;
        } else if (index != 0 && tmp.getNext() != null) {

            for (int i = 0; i <= index; i++) {

                if (tmp.getNext() != null && i == index) {
                    itemRemoved = (T) tmp.getNext().getElement();
                    tmp.setNext(tmp.getNext().getNext());
                    size--;
                    return (T) itemRemoved;
                }

                tmp = tmp.getNext();
            }
        }

        return null;
    }

    public T removeAtStart() {

        if (primeiro.getNext() != null) {
            Cell tmp = primeiro.getNext().getNext();
            Object returnElement = (T) primeiro.getNext().getElement();
            primeiro.setNext(tmp);
            size--;
            return (T) returnElement;
        } else {
            return (T) primeiro.getElement();
        }
    }

    public T removeAtEnd() {

        Cell tmp = primeiro;
        Cell ant = primeiro;
        Object returnElement = null;

        while (tmp != null) {

            if (tmp.getNext() == null && tmp.equals(ultimo)) {
                returnElement = tmp.getElement();
                ant.setNext(null);
                ultimo = null;
                ultimo = ant;
                size--;

                return (T) returnElement;
            }

            ant = tmp;
            tmp = tmp.getNext();

        }

        return (T) returnElement;
    }

}
