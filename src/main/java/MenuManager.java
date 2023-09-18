import java.util.List;
import java.util.Scanner;

public class MenuManager {
    PersonManagerRepository personManagerRepository;
    Scanner scan;

    public MenuManager() {
        personManagerRepository = new PersonManagerRepository();
        scan = new Scanner(System.in);
    }

    public void handle() {
        while (true) {
            int option = showMenu();
            int OPTION_TO_EXIT = 6;
            if (option == OPTION_TO_EXIT) break;

            actions(option);
        }
    }

    private int showMenu() {
        System.out.println("[ 1 ] Inserir um usuário");
        System.out.println("[ 2 ] Pegar usuário pelo id");
        System.out.println("[ 3 ] Pegar todos os usuários");
        System.out.println("[ 4 ] Remover o usuário");
        System.out.println("[ 5 ] Atualizar o usuiário");
        System.out.println("[ 6 ] Sair");
        System.out.print("Digite aqui: ");

        return Integer.parseInt(scan.nextLine());
    }

    private void actions(int option) {
        switch (option) {
            case 1 -> {
                addPerson();
            }
            case 2 -> {
                getPerson();
            }
            case 3 -> {
                getAllPersons();
            }
            case 4 -> {
                removePerson();
            }
            case 5 -> {
                updatePerson();
            }
        }
    }

    private void addPerson() {
        System.out.print("Digite o nome: ");
        String name = scan.nextLine();
        Person person = new Person();
        person.name = name;
        this.personManagerRepository.insertPerson(person);

        System.out.println();
        System.out.println("Adicionado com sucesso!");
        System.out.println();
    }

    private void getPerson() {
        System.out.print("Digite o id: ");
        long id = Long.parseLong(scan.nextLine());

        Person person = this.personManagerRepository.getById(id);

        System.out.println();
        System.out.println("name: " + person.name);
        System.out.println("id: " + person.getId());
        System.out.println();
    }

    private void getAllPersons() {
        List<Person> persons = this.personManagerRepository.getById();
        persons.forEach((el) -> {
            System.out.println();
            System.out.println("Name: " + el.name);
            System.out.println("ID: " + el.getId());
            System.out.println();
        });
    }

    private void removePerson() {
        System.out.print("Digite o id: ");
        long id = Long.parseLong(scan.nextLine());
        this.personManagerRepository.removeById(id);
    }

    private void updatePerson() {
        System.out.print("Id da pessoa: ");
        long id = Long.parseLong(scan.nextLine());

        System.out.print("Novo nome: ");
        String name = scan.nextLine();

        Person personUpdated = new Person();
        personUpdated.name = name;
        personUpdated.setId(id);

        this.personManagerRepository.updatePerson(personUpdated);
    }
}
