import java.util.*;
import java.util.Arrays;
import java.util.function.UnaryOperator;


public class MyList<T> implements List<T>, AuthorHolder {

    private Object[] Elements;
    private int Size;

    public MyList(int size) {
        Elements = new Object[size];
        this.Size = size;
    }

    public MyList() {
        Elements = new Object[0];
        Size = 0;
    }

    public MyList(T[] c) {
        Size = c.length;
        Elements = new Object[Size];
        System.arraycopy(c, 0, Elements, 0, Size);
    }


    @Override
    public int size() {
        return Size;
    }

    @Override
    public boolean isEmpty() {
        return Size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < Size; i++) {
            if (Elements[i].equals(o)) return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;/////////////////////////////////////////////////////
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[Size];
        System.arraycopy(Elements, 0, arr, 0, Size);
        return arr;
    }

    @Override
    public <E> E[] toArray(E[] a) {
        if (a.length < Size) return (E[]) Arrays.copyOf(Elements, Size, a.getClass());
        for (int i = 0; i < Size; i++) {
            a[i] = (E) Elements[i];
        }
        if (a.length > Size) a[Size] = null;
        return a;
    }

    @Override
    public boolean add(T t) {
        Object[] newArr = new Object[Size + 1];
        if (Size >= 0) System.arraycopy(Elements, 0, newArr, 0, Size);
        newArr[Size] = t;
        Size++;
        Elements = newArr;
        return true;
    }


    @Override
    public boolean remove(Object o) {
        if (Size == 0) return false;
        Object[] newArr = new Object[Size + 1];
        for (int i = 0; i < Size; i++) {
            if (Elements[i] == o) {
                for (int j = i; j < Size - 1; j++) {
                    Elements[j] = Elements[j + 1];
                }
                System.arraycopy(Elements, 0, newArr, 0, Size - 1);
                Elements = newArr;
                Size--;
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Object[] arr = c.toArray();
        boolean contain = false;
        for (Object o : arr) {
            for (int j = 0; j < Size; j++) {
                if (o.equals(Elements[j])) {
                    contain = true;
                    break;
                }
            }
            if (!contain)
                return false;
            contain = false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        Object[] arrAdd = c.toArray();
        if (arrAdd.length == 0)
            return false;
        Object[] newArr = new Object[arrAdd.length + Size];
        if (Size >= 0) System.arraycopy(Elements, 0, newArr, 0, Size);
        System.arraycopy(arrAdd, 0, newArr, Size, arrAdd.length);
        Elements = newArr;
        Size += arrAdd.length;
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        Object[] arrAdd = c.toArray();
        if ((arrAdd.length == 0) || (index > Size))
            return false;
        Object[] newArr = new Object[arrAdd.length + Size];
        if (index >= 0)
            System.arraycopy(Elements, 0, newArr, 0, index);
        System.arraycopy(arrAdd, 0, newArr, index, arrAdd.length);
        System.arraycopy(Elements, index, newArr, index + arrAdd.length, Size - index);
        Elements = newArr;
        Size += arrAdd.length;
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (Size == 0) return false;
        Object[] arr = c.toArray();
        Object[] newArr = Elements;
        boolean[] removingPositions = new boolean[Size];

        for (Object o : arr) {//удаляемая коллекция
            for (int j = 0; j < Size; j++) {// список
                if (o == Elements[j]) {
                    removingPositions[j] = true;
                }
            }
        }
        for(boolean elem: removingPositions){
            if (elem)
                System.out.print(1+" ");
            else System.out.print(0+" ");
        }

        for (int i = Size-1; i > 0; i--) {
            if(removingPositions[i]){
                for(int j=){
/////////////////////////////////////////
                }
            }
        }


        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void replaceAll(UnaryOperator<T> operator) {
        List.super.replaceAll(operator);
    }

    @Override
    public void sort(Comparator<? super T> c) {
        List.super.sort(c);
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Spliterator<T> spliterator() {
        return List.super.spliterator();
    }

    @Override
    public String getAuthor() {
        return AuthorHolder.super.getAuthor();
    }
}
