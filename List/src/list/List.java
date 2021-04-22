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

        public void setProx(Cell c) {
            this.prox = c;
        }

        public Cell getProx() {
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
        ultimo.setProx(new Cell(value));
        ultimo = ultimo.getProx();
        size++;
    }

    public void addAtStart(Object value) {
        Cell tmp = primeiro.getProx();

        primeiro.setProx(new Cell(value));
        primeiro.getProx().setProx(tmp);
        size++;
    }

    public void add(int index, Object value) {

        Cell tmp = primeiro.getProx();
        Cell ant = tmp;
        int count = 0;

        while (tmp != null) {

            if (index == count) {
                Cell cell = new Cell(value);
                cell.setProx(tmp);
                ant.setProx(cell);
                size++;
                break;
            }

            ant = tmp;
            tmp = tmp.getProx();
            count++;
        }

    }

    public void set(int index, Object value) {

        Cell tmp = primeiro.getProx();
        int count = 0;

        while (tmp != null) {

            if (index == count) {
                tmp.setElement(value);
                break;
            }

            tmp = tmp.getProx();
            count++;
        }

    }

    public T get(int index) {

        int count = 0;
        Cell tmp = primeiro.getProx();
        Object value = null;

        while (tmp != null) {

            if (count == index) {
                value = (T) tmp.getElement();
                return (T) value;
            }

            tmp = tmp.getProx();
            count++;
        }

        return (T) value;
    }

    public T remove(int index) {

        Cell tmp = primeiro;
        Object itemRemoved = null;

        if (index == 0 && tmp.getProx() != null) {
            itemRemoved = (T) tmp.getProx().getElement();
            tmp.setProx(tmp.getProx().getProx());
            size--;
            return (T) itemRemoved;
        } else if (index != 0 && tmp.getProx() != null) {

            for (int i = 0; i <= index; i++) {

                if (tmp.getProx() != null && i == index) {
                    itemRemoved = (T) tmp.getProx().getElement();
                    tmp.setProx(tmp.getProx().getProx());
                    size--;
                    return (T) itemRemoved;
                }

                tmp = tmp.getProx();
            }
        }

        return null;
    }

    public T removeAtStart() {

        if (primeiro.getProx() != null) {
            Cell tmp = primeiro.getProx().getProx();
            Object returnElement = (T) primeiro.getProx().getElement();
            primeiro.setProx(tmp);
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

            if (tmp.getProx() == null && tmp.equals(ultimo)) {
                returnElement = tmp.getElement();
                ant.setProx(null);
                ultimo = null;
                ultimo = ant;
                size--;

                return (T) returnElement;
            }

            ant = tmp;
            tmp = tmp.getProx();

        }

        return (T) returnElement;
    }

}
