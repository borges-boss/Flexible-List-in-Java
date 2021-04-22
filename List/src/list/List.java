package list;

public class List<T> {

    private class Cell<T> {

        private Object element;
        private Cell next;

        public Cell() {
            this.element = null;
        }

        public Cell(Object element) {
            this.element = (T) element;
            this.next = null;
        }

        public void setElement(Object element) {
            this.element = (T) element;
        }

        public T getElement() {
            return (T) element;
        }

        public void setNext(Cell c) {
            this.next = c;
        }

        public Cell getNext() {
            return this.next;
        }

    }

    private Cell< T> first, last;
    private int size = 0;

    public List() {
        first = new Cell();
        last = first;
    }

    public int size() {
        return size;
    }

    public void add(Object value) { //final
        last.setNext(new Cell(value));
        last = last.getNext();
        size++;
    }

    public void addAtStart(Object value) {
        Cell tmp = first.getNext();

        first.setNext(new Cell(value));
        first.getNext().setNext(tmp);
        size++;
    }

    public void add(int index, Object value) {

        Cell tmp = first.getNext();
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

        Cell tmp = first.getNext();
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
        Cell tmp = first.getNext();
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

        Cell tmp = first;
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

        if (first.getNext() != null) {
            Cell tmp = first.getNext().getNext();
            Object returnElement = (T) first.getNext().getElement();
            first.setNext(tmp);
            size--;
            return (T) returnElement;
        } else {
            return (T) first.getElement();
        }
    }

    public T removeAtEnd() {

        Cell tmp = first;
        Cell ant = first;
        Object returnElement = null;

        while (tmp != null) {

            if (tmp.getNext() == null && tmp.equals(last)) {
                returnElement = tmp.getElement();
                ant.setNext(null);
                last = null;
                last = ant;
                size--;

                return (T) returnElement;
            }

            ant = tmp;
            tmp = tmp.getNext();

        }

        return (T) returnElement;
    }

}
