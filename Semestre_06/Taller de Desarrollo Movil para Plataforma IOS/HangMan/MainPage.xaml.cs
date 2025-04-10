using System.Text;

namespace HangMan;

public partial class MainPage : ContentPage
{
    // Constantes
    private const int MAX_ERRORS = 6;  // Número máximo de errores permitidos

    // Lista de palabras para el juego
    private readonly string[] _wordBank = {
        "PROGRAMACION", "XAMARIN", "MAUI", "DESARROLLO", "APLICACION",
        "INTERFAZ", "CODIGO", "ENLACE", "DATOS", "CONTROL",
        "BOTON", "ETIQUETA", "CONTENEDOR", "PAGINA", "NAVEGACION",
        "FRAMEWORK", "VISUAL", "MICROSOFT", "DOTNET", "MULTIPLATAFORMA"
    };

    // Variables del juego
    private string? _currentWord;  // Palabra que el jugador debe adivinar

    private List<char> _guessedLetters;  // Letras que el jugador ha adivinado correctamente
    private List<char> _usedLetters;  // Letras que el jugador ha intentado
    private int _errorCount;  // Número de errores cometidos
    private Random _random;  // Generador de números aleatorios para seleccionar una palabra

    public MainPage()
    {
        InitializeComponent();

        // Inicializar variables
        _random = new Random();  // Crear una nueva instancia de Random
        _guessedLetters = new List<char>();  // Lista vacía para las letras adivinadas
        _usedLetters = new List<char>();  // Lista vacía para las letras usadas

        // Iniciar el juego
        StartNewGame();  // Llamar al método que inicia un nuevo juego
    }

    // Método para iniciar un nuevo juego
    private void StartNewGame()
    {
        // Seleccionar una palabra aleatoria del banco de palabras
        _currentWord = _wordBank[_random.Next(_wordBank.Length)];

        Console.WriteLine($"Nueva palabra seleccionada: {_currentWord}");  // Mostrar la palabra seleccionada para depuración

        // Reiniciar las variables de juego
        _guessedLetters = new List<char>();  // Restablecer las letras adivinadas
        _usedLetters = new List<char>();  // Restablecer las letras usadas
        _errorCount = 0;  // Restablecer el contador de errores

        // Actualizar la imagen del ahorcado (inicialmente sin errores)
        HangmanImage.Source = "hangman_0.png";

        // Limpiar el texto de las letras usadas
        UsedLetters.Text = string.Empty;

        // Crear una cadena de guiones bajos del tamaño adecuado para la palabra
        StringBuilder initialDisplay = new StringBuilder();
        for (int i = 0; i < _currentWord.Length; i++)
        {
            initialDisplay.Append('_');  // Agregar guión bajo para cada letra de la palabra
            if (i < _currentWord.Length - 1)
                initialDisplay.Append(' ');  // Agregar espacio entre los guiones
        }

        // Establecer el texto inicial de la palabra a adivinar
        WordToGuess.Text = initialDisplay.ToString();

        // Habilitar todos los botones de letras
        EnableAllButtons(true);
    }

    // Método para actualizar la visualización de la palabra en función de las letras adivinadas
    private void UpdateWordDisplay()
    {
        if (string.IsNullOrEmpty(_currentWord))
        {
            // Si no hay palabra seleccionada, mostrar mensaje de error
            WordToGuess.Text = "ERROR: NO WORD";
            return;
        }

        // Crear una lista de caracteres para mostrar la palabra
        char[] displayChars = new char[_currentWord.Length * 2 - 1];

        for (int i = 0; i < _currentWord.Length; i++)
        {
            // Mostrar la letra si ha sido adivinada, de lo contrario, mostrar un guion bajo
            char letterToShow = _guessedLetters.Contains(_currentWord[i]) ? _currentWord[i] : '_';
            displayChars[i * 2] = letterToShow;

            // Agregar un espacio entre las letras (excepto después de la última)
            if (i < _currentWord.Length - 1)
                displayChars[i * 2 + 1] = ' ';
        }

        // Convertir el arreglo de caracteres a cadena y actualizar la visualización de la palabra
        WordToGuess.Text = new string(displayChars);

        // Información de depuración
        Console.WriteLine($"Word to display: '{WordToGuess.Text}'");
        Console.WriteLine($"Label text is now: '{WordToGuess.Text}'");
    }

    // Método para habilitar o deshabilitar todos los botones de letras
    private void EnableAllButtons(bool enable)
    {
        foreach (Button button in GetAllLetterButtons())
        {
            button.IsEnabled = enable;  // Habilitar o deshabilitar cada botón
        }
    }

    // Método para obtener todos los botones de letras
    private IEnumerable<Button> GetAllLetterButtons()
    {
        List<Button> buttons = new List<Button>();

        // Buscar todos los Frame dentro de la cuadrícula principal
        var frames = this.FindByName<Grid>("MainGrid").Children.OfType<Frame>().ToList();

        foreach (var frame in frames)
        {
            // Si es el Frame que contiene el teclado (último Frame en el diseño)
            if (frame.Content is VerticalStackLayout vLayout)
            {
                // Buscar todos los FlexLayout dentro del VerticalStackLayout
                foreach (var child in vLayout.Children)
                {
                    if (child is FlexLayout flexLayout)
                    {
                        // Añadir todos los botones dentro del FlexLayout
                        foreach (var button in flexLayout.Children.OfType<Button>())
                        {
                            // Solo añadir botones que tengan un solo carácter (letras)
                            if (button.Text.Length == 1)
                            {
                                buttons.Add(button);
                            }
                        }
                    }
                }
            }
        }

        return buttons;
    }

    // Manejador del evento Click para los botones de letras
    private void OnLetterClicked(object sender, EventArgs e)
    {
        if (sender is Button button)
        {
            // Obtener la letra del botón
            char letter = button.Text[0];

            // Deshabilitar el botón de la letra seleccionada
            button.IsEnabled = false;

            // Añadir la letra a las letras usadas
            _usedLetters.Add(letter);
            UsedLetters.Text = string.Join(", ", _usedLetters);  // Mostrar letras usadas

            // Verificar si la letra está en la palabra
            bool letterFound = false;

            for (int i = 0; i < _currentWord.Length; i++)
            {
                if (_currentWord[i] == letter)
                {
                    _guessedLetters.Add(letter);  // Agregar la letra correcta a las adivinadas
                    letterFound = true;
                }
            }

            // Actualizar la visualización de la palabra
            UpdateWordDisplay();

            if (letterFound)
            {
                // Si la letra fue encontrada, verificar si el jugador ha ganado
                CheckForWin();
            }
            else
            {
                // Si la letra no fue encontrada, incrementar el contador de errores
                _errorCount++;

                // Actualizar la imagen del ahorcado según los errores cometidos
                HangmanImage.Source = $"hangman_{_errorCount}.png";

                // Verificar si el jugador ha perdido
                CheckForLoss();
            }
        }
    }

    // Método para verificar si el jugador ha ganado
    private async void CheckForWin()
    {
        bool hasWon = true;

        foreach (char letter in _currentWord)
        {
            if (!_guessedLetters.Contains(letter))  // Si alguna letra no ha sido adivinada
            {
                hasWon = false;
                break;
            }
        }

        if (hasWon)
        {
            // Mostrar mensaje de victoria
            await DisplayAlert("¡Felicidades!", $"¡Has ganado! La palabra era: {_currentWord}", "OK");

            // Iniciar un nuevo juego
            StartNewGame();
        }
    }

    // Método para verificar si el jugador ha perdido
    private async void CheckForLoss()
    {
        if (_errorCount >= MAX_ERRORS)  // Si el jugador ha alcanzado el número máximo de errores
        {
            // Mostrar mensaje de derrota
            await DisplayAlert("¡Game Over!", $"La palabra era: {_currentWord}", "OK");

            // Iniciar un nuevo juego
            StartNewGame();
        }
    }

    // Manejador del evento Click para el botón de nuevo juego
    private void OnNewGameClicked(object sender, EventArgs e)
    {
        StartNewGame();  // Iniciar un nuevo juego al hacer clic en el botón "Nuevo Juego"
    }
}