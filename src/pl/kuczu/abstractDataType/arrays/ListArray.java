package pl.kuczu.abstractDataType.arrays;

public class ListArray {
    private int maxSize;
    private long list[];
    private int lastIdx;

    public ListArray(int maxSize) {
        this.maxSize = maxSize;
        this.list = new long[maxSize];
        this.lastIdx = 0;
    }

    private boolean isPositionExists(int idx){
        return !((idx > lastIdx) || (idx < 0));
    }

    public int first(){
        return 0;
    }

    public int end(){
        return lastIdx;
    }

    private void moveListElemToRight(int idx){
        for(int i = lastIdx; i > idx; i--){
            list[i] = list[i - 1];
        }
    }

    private void moveListElemToLeft(int idx){
        for(int i = idx; i < lastIdx; i++){
            list[i] = list[i + 1];
        }
    }

    public int locate(long searchElem){
        for(int i = 0; i < lastIdx; i++){
            if(list[i] == searchElem){
                return i;
            }
        }

        return -1;
    }

    public void insert(long value, int idx){
        if(lastIdx >= maxSize){
            System.out.println("Lista pełna!");
        }
        else if(!isPositionExists(idx)){
            System.out.println("Pozycja " + idx + " nie istnieje!");
        }
        else{
            moveListElemToRight(idx);

            list[idx] = value;
            lastIdx++;
        }
    }

    public void delete(int idx){
        if(lastIdx == 0){
            System.out.println("Lista jest pusta!");
        }
        else if(!isPositionExists(idx)){
            System.out.println("Pozycja " + idx + " nie istnieje!");
        }
        else{
            moveListElemToLeft(idx);

            lastIdx--;
        }
    }

    public void printList(){
        if(lastIdx == 0){
            System.out.println("Lista jest pusta!");
        }
        else{
            for(int i = 0; i < lastIdx; i++){
                System.out.print(list[i] + " ");
            }
            System.out.println();
        }
    }

    public long retValFromPos(int idx){
        if(!isPositionExists(idx)){
            System.out.println("Pozycja " + idx + " nie istnieje!");
            return -1;
        }
        else{
            return list[idx];
        }
    }

    public int nextIdx(int idx){
        if((idx > lastIdx - 1) || (idx < 0)){
            System.out.println("Pozycja " + idx + " nie istnieje!");
            return -1;
        }

        return idx + 1;
    }

    public int prevIdx(int idx){
        if((idx > lastIdx) || (idx < 1)){
            System.out.println("Pozycja " + idx + " nie istnieje!");
            return -1;
        }

        return idx - 1;
    }
}
