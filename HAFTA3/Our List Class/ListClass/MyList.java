package ListClass;


public class MyList<T extends Object> {

    private T[] array;
    int size;
    int capacity;

    public MyList() {
        this.array = (T[]) new Object[10];
        this.size = 0;
        this.capacity = 10;
    }

    public MyList(int capacity) {
        this.array = (T[]) new Object[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public int size(){
        return this.size;
    }

    public int getCapacity(){
        return array.length;
    }

    public void add(T data){
        if(size >= capacity){
            capacity *= 2;
            T[] newArray = (T[]) new Object[capacity];
            for(int i=0; i<size; i++){
                newArray[i] = this.array[i];
            }
            this.array = newArray;
        }
        this.array[size] = data;
        this.size++;
    }

    public T get(int index){
        if(index > -1 && index < size) {
            return this.array[index];
        }
        return null;
    }

    public T remove(int index){
        if(index > -1 && index < size) {
            T temp = array[index];
            int i;
            for (i = index; i < size - 1; i++) {
                this.array[i] = this.array[i + 1];
            }

            T[] temp2 = (T[]) new Object[capacity];
            for(int a=0; a<size-1; a++) {
                temp2[a] = this.array[a];
            }

            this.array = temp2;

            this.size--;

            return temp;
        }
        return null;
    }

    public Object set(int index, T data){
        if(index < 0 && index >= capacity) return null;
        array[index] = data;
        return array[index];
    }

    public String toString(){
        if(size <= 0) return " ";
        String text ="[";
        text += array[0].toString();
        if(size == 1){
            return text + ",";
        }
        for(int i =1; i < size; i++){
            text += "," + array[i].toString();
        }
        text += "]";
        return text;
    }

    public int indexOf(Object data){
        for(int i=0; i<size; i++){
            if(data == array[i])
                return i;
        }
        return -1;
    }

    public int lastIndexOf(Object data){
        for(int i=size; i>0; i--){
            if(data == array[i])
                return i;
        }
        return -1;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public T[] toArray(){
        return array;
    }

    public void clear(){
        T[] newArray = (T[]) new Object[0];
        this.array = newArray;
        size = 0;
    }

    public MyList<T> subList(int start,int finish){
        MyList<T> temp = new MyList<>(finish-start);
        temp.array = (T[]) new Object[finish - start];
        for(int i=start; i<finish; i++){
            temp.add(this.array[i]);
        }
        return temp;
    }

    public boolean contains(T data){
        for(int i=0; i<size; i++){
            if(this.array[i] == data) {
                return true;
            }
        }
        return false;
    }

}
