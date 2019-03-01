package DataStructure.Queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author OliverYu
 * @Date 2019/3/1 14:54
 * @Email 253757635@qq.com
 * @Description TODO
 */
public class Queue_03_DogCatQueue {

    /**
     * 猫狗队列:
     *  宠物、狗和猫的类如下
     * public class Pet {
     *         private String type;
     *
     *         public  Pet(String type) {
     *             this.type = type;
     *         }
     *
     *         public String getPetType() {
     *             return this.type;
     *         }
     *     }
     *
     *     public class Dog extends Pet {
     *
     *         public Dog(String type) {
     *             super("dog");
     *         }
     *     }
     *
     *     public class Cat extends Pet {
     *
     *         public Cat(String type) {
     *             super("cat");
     *         }
     *     }
     *
     *     实现一种狗猫队列的结构，要求如下：
     *         用户可以调用add方法将cat类或dog类的实例放入队列中；
     *         用户可以调用pollAll方法，将队列中所有的实例按照进队列的先后顺序依次弹出；
     *         用户可以调用pollDog方法，将队列中dog类的实例按照进队列的先后顺序依次弹出；
     *         用户可以调用pollCat方法，将队列中cat类的实例按照进队列的先后顺序依次弹出；
     *         用户可以调用isEmpty方法，检查队列中是否还有dog或cat的实例；
     *         用户可以调用isDogEmpty方法，检查队列中是否有dog类的实例；
     *         用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例。
     */
    public static class Pet {
        private String type;

        public  Pet(String type) {
            this.type = type;
        }

        public String getPetType() {
            return this.type;
        }
    }

    public static class Dog extends Pet {

        public Dog(String type) {
            super("dog");
        }
    }

    public static class Cat extends Pet {

        public Cat(String type) {
            super("cat");
        }
    }

    public static class PetEnter {
        private Pet pet;
        private long count;

        public PetEnter(Pet pet,long count) {
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet() {
            return pet;
        }

        public long getCount() {
            return count;
        }

        public String getEntrePetType() {
            return pet.getPetType();
        }
    }

    public static class DogCatQueue{
        private Queue<PetEnter> dogQueue;
        private Queue<PetEnter> catQueue;
        private long count;

        public DogCatQueue() {
            dogQueue = new LinkedList<>();
            catQueue = new LinkedList<>();
            count = 0;
        }

        public void add(Pet pet) {
            if (pet.getPetType().equals("dog")) {
                dogQueue.add(new PetEnter(pet,count++));
            }else if (pet.getPetType().equals("cat")) {
                catQueue.add(new PetEnter(pet,count++));
            }else {
                throw new RuntimeException("Error,the pet is either of dog or cat~");
            }
        }

        public Pet pollAll() {
            if (!dogQueue.isEmpty() && !catQueue.isEmpty()) {
                if (dogQueue.peek().getCount() < catQueue.peek().getCount()) {
                    return dogQueue.poll().getPet();
                }else {
                    return catQueue.poll().getPet();
                }
            }else if (!isDogEmpty()) {
                return dogQueue.poll().getPet();
            }else if (!isCatEmpty()) {
                return catQueue.poll().getPet();
            }else {
                throw new RuntimeException("Error,Empty!");
            }
        }

        public Dog pollDog() {
            if (dogQueue.isEmpty()) {
                throw new RuntimeException("Error,the dogQueue is empty!");
            }
            return (Dog) dogQueue.poll().getPet();
        }

        public Cat pollCat() {
            if (catQueue.isEmpty()) {
                throw new RuntimeException("Error,the cat queue is empty!");
            }
            return (Cat) catQueue.poll().getPet();
        }

        public boolean isEmpty() {
            return isDogEmpty()&&isCatEmpty();
        }

        public boolean isDogEmpty() {
            return dogQueue.isEmpty();
        }

        public boolean isCatEmpty() {
            return catQueue.isEmpty();
        }
    }

    public static void main(String[] args) {
        DogCatQueue dogCatQueue = new DogCatQueue();

        Pet dog1 = new Dog("dog");
        Pet cat1 = new Cat("cat");
        Pet dog2 = new Dog("dog");
        Pet cat2 = new Cat("cat");
        Pet dog3 = new Dog("dog");
        Pet cat3 = new Cat("cat");

        dogCatQueue.add(dog1);
        dogCatQueue.add(cat1);
        dogCatQueue.add(dog2);
        dogCatQueue.add(cat2);
        dogCatQueue.add(dog3);
        dogCatQueue.add(cat3);

        while (!dogCatQueue.isDogEmpty()) {
            System.out.println(dogCatQueue.pollDog().getPetType());
        }
        System.out.println("==============");
        while (!dogCatQueue.isEmpty()) {
            System.out.println(dogCatQueue.pollAll().getPetType());
        }
    }
}
