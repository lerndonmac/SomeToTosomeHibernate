import DAO.DAO;
import model.Authors;
import model.Books;
import model.Genre;
import model.Users;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import service.ServiceAuthors;
import service.ServiceBooks;
import service.ServiceGenre;
import service.ServiceUsers;

import java.util.*;

public class Prog {
    public static void main(String[] args) {
        Scanner scannerOfChoose = new Scanner(System.in);
        Scanner scannerOfStrings = new Scanner(System.in);
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        String category = "";
        String type = "";

        DAO<Books, Integer> DAOBooks = new ServiceBooks(factory);
        Books book = new Books();
        List<Books> listOfBooks = new ArrayList<>();

        DAO<Authors, Integer> DAOAuthors = new ServiceAuthors(factory);
        Authors author = new Authors();
        List<Authors> listOfAuthors = new ArrayList<>();

        DAO<Users, Integer> DAOUsers = new ServiceUsers(factory);
        Users user = new Users();
        List<Users> listOfUsers = new ArrayList<>();

        DAO<Genre, Integer> DAOGenre = new ServiceGenre(factory);
        Genre genre = new Genre();
        List<Genre> listOfGenre = new ArrayList<>();


        while (category.equals("")){
//            System.out.println("insert categiry(u/b/a/g)");
            System.out.println("insert categiry(b/g)");
            category = scannerOfChoose.nextLine();
        }

        if (category.equals("u")){
            while (type.equals("")){
                System.out.println("insert type(c/r/u/d)");
                type = scannerOfChoose.nextLine();
            }
            if (type.equals("c")){

            }
            if (type.equals("r")){

            }
            if (type.equals("u")){

            }
            if (type.equals("d")){

            }


        }//user categiri empty
        if (category.equals("b")){
            while (type.equals("")){
                System.out.println("insert type(c/r/u/d)");
                type = scannerOfChoose.nextLine();
            }
            if (type.equals("c")){
                List<Genre> genreList = new ArrayList<>();
                List<Authors> authorsList = new ArrayList<>();
                List<Users> usersList = new ArrayList<>();

                String bookTitle = "";
                String bookYear = "";
                int genreId = 0;
                int autorId = 0;
                int userId = 0;

                while (bookTitle.equals("")){
                    System.out.println("insert book title");
                    bookTitle = scannerOfStrings.nextLine();
                }
                while (bookYear.equals("")){
                    System.out.println("insert book year");
                    bookYear = scannerOfStrings.nextLine();
                }

                genreList = DAOGenre.readByAll();
                for (Genre genre1: genreList){
                    System.out.println(genre1.toString());
                }
                while (genreId == 0){
                    System.out.println("insert genre Id");
                    genreId = scannerOfStrings.nextInt();
                }

                authorsList = DAOAuthors.readByAll();
                for (Authors authors: authorsList){
                    System.out.println(authors.toString());
                }
                while (autorId == 0){
                    System.out.println("insert author Id");
                    autorId = scannerOfStrings.nextInt();
                }
                Set<Authors> authorsSet = new HashSet<>();
                authorsSet.add(DAOAuthors.read(autorId));

                usersList = DAOUsers.readByAll();
                for (Users users: usersList){
                    System.out.println(users.toString());
                }
                while (userId == 0){
                    System.out.println("insert user Id");
                    userId = scannerOfStrings.nextInt();
                }
                Set<Users> usersSet = new HashSet<>();
                usersSet.add(DAOUsers.read(userId));

                book.setAuthors(authorsSet);
                book.setGenreId(DAOGenre.read(genreId));
                book.setTitle(bookTitle);
                book.setPublishYear(bookYear);
                book.setUsers(usersSet);

                DAOBooks.create(book);
                factory.close();
            }
            if (type.equals("r")){
                List<Books> booksList = new ArrayList<>();
                booksList = DAOBooks.readByAll();
                for (Books books : booksList){
                    System.out.println(books.toString());
                }
            }
            if (type.equals("u")){
                List<Books> booksList = new ArrayList<>();
                List<Genre> genreList = new ArrayList<>();
                List<Authors> authorsList = new ArrayList<>();
                List<Users> usersList = new ArrayList<>();
                String bookTitle = "";
                String bookYear = "";
                int genreId = 0;
                int autorId = 0;
                int userId = 0;
                int bookId = 0;
                while (bookTitle.equals("")){
                    System.out.println("insert book title");
                    bookTitle = scannerOfStrings.nextLine();
                }
                while (bookYear.equals("")){
                    System.out.println("insert book year");
                    bookYear = scannerOfStrings.nextLine();
                }

                booksList = DAOBooks.readByAll();
                for (Books books: booksList){
                    System.out.println(books.toString());
                }
                while (bookId == 0){
                    System.out.println("insert book id");
                    bookId = scannerOfStrings.nextInt();
                }

                genreList = DAOGenre.readByAll();
                for (Genre genre1: genreList){
                    System.out.println(genre1.toString());
                }
                while (genreId == 0){
                    System.out.println("insert genre Id");
                    genreId = scannerOfStrings.nextInt();
                }

                authorsList = DAOAuthors.readByAll();
                for (Authors authors: authorsList){
                    System.out.println(authors.toString());
                }
                while (autorId == 0){
                    System.out.println("insert author Id");
                    autorId = scannerOfStrings.nextInt();
                }
                Set<Authors> authorsSet = new HashSet<>();
                authorsSet.add(DAOAuthors.read(autorId));

                usersList = DAOUsers.readByAll();
                for (Users users: usersList){
                    System.out.println(users.toString());
                }
                while (userId == 0){
                    System.out.println("insert user Id");
                    userId = scannerOfStrings.nextInt();
                }
                Set<Users> usersSet = new HashSet<>();
                usersSet.add(DAOUsers.read(userId));

                book.setId(bookId);
                book.setAuthors(authorsSet);
                book.setGenreId(DAOGenre.read(genreId));
                book.setTitle(bookTitle);
                book.setPublishYear(bookYear);
                book.setUsers(usersSet);

                factory.close();
            }
            if (type.equals("d")){
                List<Books> booksList = new ArrayList<>();
                int bookId = 0;
                booksList = DAOBooks.readByAll();
                for (Books books: booksList){
                    System.out.println(books.toString());
                }
                while (bookId == 0){
                    System.out.println("insert book id");
                    bookId = scannerOfStrings.nextInt();
                }
                DAOBooks.delete(DAOBooks.read(bookId));

                factory.close();
            }

        }// books categiri
        if (category.equals("a")){
            while (type.equals("")){
                System.out.println("insert type(c/r/u/d)");
                type = scannerOfChoose.nextLine();
            }
            if (type.equals("c")){

            }
            if (type.equals("r")){

            }
            if (type.equals("u")){

            }
            if (type.equals("d")){

            }

        }//authors categiri empty
        if (category.equals("g")){
            while (type.equals("")){
                System.out.println("insert type(c/r/u/d)");
                type = scannerOfChoose.nextLine();
            }
            if (type.equals("c")){
                String genreName = "";
                while (genreName.equals("")){
                    System.out.println("insert genre name");
                    genreName = scannerOfStrings.nextLine();
                }
                genre.setGenreName(genreName);
            }
            if (type.equals("r")){
                List<Genre> genreList = new ArrayList<>();
                genreList = DAOGenre.readByAll();
                for (Genre genre1:genreList){
                    System.out.println(genre1.toString());
                }
            }
            if (type.equals("u")){
                List<Genre> genreList = new ArrayList<>();
                genreList = DAOGenre.readByAll();
                for (Genre genre1:genreList){
                    System.out.println(genre1.toString());
                }
                int genreId = 0;
                while (genreId == 0){
                    System.out.println("insert genre id");
                    genreId = scannerOfStrings.nextInt();
                }

                String genreName = "";
                while (genreName.equals("")){
                    System.out.println("insert genre name");
                    genreName = scannerOfStrings.nextLine();
                }
            }
            if (type.equals("d")){
                List<Genre> genreList = new ArrayList<>();
                genreList = DAOGenre.readByAll();
                for (Genre genre1:genreList){
                    System.out.println(genre1.toString());
                }
                int genreId = 0;
                while (genreId == 0){
                    System.out.println("insert genre id");
                    genreId = scannerOfStrings.nextInt();
                }
                DAOGenre.delete(DAOGenre.read(genreId));

            }

        }//genre categiri

    }

}
