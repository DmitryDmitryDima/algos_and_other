package language.sealedstuff;

public class SealedExamples {
}




// sealed обязательно должен иметь наследника
sealed interface Ex permits Alpha, Beta {

}

// класс наследник от sealed должен быть либо final, либо sealed, либо non-sealed
// non-sealed означает, что класс открыт к наследованию
non-sealed class Alpha implements Ex{

}

// обычное наследование от non-sealed класса
class Simple extends Alpha{

}

// пример с sealed наследником (также обязан иметь наследника)
sealed class Beta implements Ex permits Gamma{

}

// пример с final наследником
final class Gamma extends Beta{

}


