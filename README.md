# Simple Java Programs

A collection of simple Java programs developed during my [MSc Computer Science](https://www.ucl.ac.uk/prospective-students/graduate/taught-degrees/computer-science-msc) degree at [UCL](https://www.ucl.ac.uk/).

## Installation
In order to use the code inside this repository, you will need to have [Java](https://www.java.com/en/download/) installed. You can then use `javac` to compile any code snippet you want to run:

```sh
$ javac tutorial_0/CurrentDate.java
```

To run the `CurrentDate` program, all you need to do is execute:
```sh
$ java tutorial_0/CurrentDate
```

Alternatively, you can use an IDE such as [Eclipse](https://www.eclipse.org/downloads/) or [IntelliJ IDEA](https://www.jetbrains.com/idea/).

:warning: Please not that this repository does not ship with any dependencies, hence, if you see an import statement such as: `import javax.swing.JPanel;`, then you need to make sure you have the jar file of this dependency loaded into your classpath before starting the program.

## Project Structure

```
.
├── src
├── tutorial_0
│   ├── CurrentDate.java
│   ├── ForLoop.java
│   ├── HelloWorld.java
│   ├── InputOutput.java
│   └── NameValidation.java
├── tutorial_1
│   ├── Arrays.java
│   ├── ByteConversion.java
│   ├── Chess.java
│   ├── Factorial.java
│   ├── Methods.java
│   └── Types.java
├── tutorial_2
│   ├── ArrElementRem.java
│   ├── Arraylist.java
│   ├── IntEven.java
│   ├── PascalTriangle.java
│   └── Vectors.java
├── tutorial_3
│   ├── CreditCard.java
│   ├── CreditCardTester.java
│   ├── DNAStrand.java
│   ├── DNAStrandTester.java
│   ├── Robot1.java
│   └── Robot2.java
├── tutorial_4
│   ├── CountLines.java
│   ├── currency_converter
│   │   ├── Currency.java
│   │   ├── CurrencyConverter.java
│   │   └── Reader.java
│   │   └── rates.txt
│   └── whack_a_mole
│       └── MoleGame.java
└── tutorial_5
    ├── Logging_Chess_Javadoc.java
    ├── balls
    │   ├── BallEntity.java
    │   ├── BallGame.java
    │   └── Renderer.java
    └── xml
        ├── SimpleErrorHandler.java
        └── Xml.java
```
