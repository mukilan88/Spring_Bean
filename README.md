Developing a Spring Application in Eclipse using Maven
------------------------------------------------------
- Create a Maven Project

	Click on File -> New -> Maven Project

	Click Next

	In Catalog Select : Internal
	In Artifact Id Select : maven-archetype-quickstart

	Click Next

	Group Id : spring
	Artifact Id : SpringProj
	Package : com.spring

	and click Finish

- Add the following dependency in between <dependencies> element of pom.xml file of SpringProj

Copy this and past it in pom.xml 

	<dependency>
    		<groupId>org.springframework</groupId>
    		<artifactId>spring-context</artifactId>
    		<version>4.3.10.RELEASE</version>
	</dependency>

- Create a Spring bean class "Book" in com.spring package of src/main/java folder of SpringProj

    package com.spring;
    public class Book {
	private int bookId;
	private String bookName;
	public Book(int bookId, String bookName) // constructor injection
	{
		this.bookId = bookId;
		this.bookName = bookName;
	}
	public Book() {
	}
	public String toString() {
		return bookId + " " + bookName;
	}
    }
-----------------------------------------------------
- Create a Spring bean class "Library" in com.spring package

    package com.spring;
    import java.util.List;
    public class Library {
	private List<Book> books;// property
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) { // setter injection
		this.books = books;
	}
    }
-----------------------------------------------------

- Create spring bean XML configuration file "library.xml" in src/main/java folder
    <beans xmlns="http://www.springframework.org/schema/beans"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns:context="http://www.springframework.org/schema/context"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context-3.0.xsd">
        <bean id="lib" class="com.spring.Library">
            <property name="books">
                <list>
                    <ref bean="book1" />
                    <ref bean="book2" />
                    <ref bean="book3" />
                </list>
            </property>
        </bean>
        <bean id="book1" class="com.spring.Book">
            <constructor-arg value="111" />
            <constructor-arg value="Learn Spring" />
        </bean>
        <bean id="book2" class="com.spring.Book">
            <constructor-arg value="222" />
            <constructor-arg value="Learn Hibernate" />
        </bean>
        <bean id="book3" class="com.spring.Book">
            <constructor-arg value="333" />
            <constructor-arg value="Learn Angular" />
        </bean>
    </beans>
-----------------------------------------------------
- Create a test class "LibraryTest" in com.spring package
    package com.spring;
    import java.util.List;
    import org.springframework.context.ApplicationContext;
    import org.springframework.context.support.ClassPathXmlApplicationContext;
    public class LibraryTest {
        public static void main(String[] args) {
            ApplicationContext context = new ClassPathXmlApplicationContext("library.xml");
            Library lib = (Library) context.getBean("lib");
            List<Book> books = lib.getBooks();
            for (Book b : books)
                System.out.println(b);
        }
    }
-----------------------------------------------------
