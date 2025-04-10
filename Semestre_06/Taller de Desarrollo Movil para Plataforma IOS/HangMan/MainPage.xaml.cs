using System.Text;

namespace HangMan;

public partial class MainPage : ContentPage
{
    // Constantes
    private const int MAX_ERRORS = 6;

    // Lista de palabras para el juego
    private readonly string[] _wordBank = {
        "PROGRAMACION", "XAMARIN", "MAUI", "DESARROLLO", "APLICACION",
        "INTERFAZ", "CODIGO", "ENLACE", "DATOS", "CONTROL",
        "BOTON", "ETIQUETA", "CONTENEDOR", "PAGINA", "NAVEGACION",
        "FRAMEWORK", "VISUAL", "MICROSOFT", "DOTNET", "MULTIPLATAFORMA"
    };

    // Variables del juego
    private string? _currentWord;

    private List<char> _guessedLetters;
    private List<char> _usedLetters;
    private int _errorCount;
    private Random _random;

    public MainPage()
    {
        InitializeComponent();

        // Inicializar variables
        _random = new Random();
        _guessedLetters = new List<char>();
        _usedLetters = new List<char>();

        // Iniciar el juego
        StartNewGame();
    }

    // Método para iniciar un nuevo juego
    private void StartNewGame()
	{
		// Seleccionar una palabra aleatoria
		_currentWord = _wordBank[_random.Next(_wordBank.Length)];

		Console.WriteLine($"Nueva palabra seleccionada: {_currentWord}");

		// Reiniciar variables
		_guessedLetters = new List<char>();
		_usedLetters = new List<char>();
		_errorCount = 0;

		// Actualizar la imagen
		HangmanImage.Source = "hangman_0.png";

		// Limpiar letras usadas
		UsedLetters.Text = string.Empty;

		// Crear una cadena de guiones bajos del tamaño adecuado
		StringBuilder initialDisplay = new StringBuilder();
		for (int i = 0; i < _currentWord.Length; i++)
		{
			initialDisplay.Append('_');
			if (i < _currentWord.Length - 1)
				initialDisplay.Append(' ');
		}

		// Establecer el texto inicial
		WordToGuess.Text = initialDisplay.ToString();

		// Habilitar todos los botones
		EnableAllButtons(true);
	}

    private void UpdateWordDisplay()
	{
		if (string.IsNullOrEmpty(_currentWord))
		{
			// Set a default message if the word is null or empty
			WordToGuess.Text = "ERROR: NO WORD";
			return;
		}

		// Create a character array to build the display
		char[] displayChars = new char[_currentWord.Length * 2 - 1];
		
		for (int i = 0; i < _currentWord.Length; i++)
		{
			char letterToShow = _guessedLetters.Contains(_currentWord[i]) ? _currentWord[i] : '_';
			displayChars[i * 2] = letterToShow;
			
			// Add spaces between characters (except after the last one)
			if (i < _currentWord.Length - 1)
				displayChars[i * 2 + 1] = ' ';
		}
		
		// Convert to string and set directly
		WordToGuess.Text = new string(displayChars);
		
		// Debug info
		Console.WriteLine($"Word to display: '{WordToGuess.Text}'");
		Console.WriteLine($"Label text is now: '{WordToGuess.Text}'");
	}

    // Método para habilitar o deshabilitar todos los botones
    private void EnableAllButtons(bool enable)
    {
        foreach (Button button in GetAllLetterButtons())
        {
            button.IsEnabled = enable;
        }
    }

    // Método para obtener todos los botones de letras
    private IEnumerable<Button> GetAllLetterButtons()
    {
        List<Button> buttons = new List<Button>();

        // Buscar todos los VerticalStackLayout dentro de Frames
        var frames = this.FindByName<Grid>("MainGrid").Children.OfType<Frame>().ToList();

        foreach (var frame in frames)
        {
            // Si es el frame que contiene el teclado (último frame en nuestro diseño)
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
                            // Solo añadir botones con un solo carácter (botones de letras)
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

            // Deshabilitar el botón
            button.IsEnabled = false;

            // Añadir la letra a las letras usadas
            _usedLetters.Add(letter);
            UsedLetters.Text = string.Join(", ", _usedLetters);

            // Verificar si la letra está en la palabra
            bool letterFound = false;

            for (int i = 0; i < _currentWord.Length; i++)
            {
                if (_currentWord[i] == letter)
                {
                    _guessedLetters.Add(letter); // Agregar la letra correcta a las adivinadas
                    letterFound = true;
                }
            }

            // Actualizar la visualización de la palabra
            UpdateWordDisplay();

            if (letterFound)
            {
                // Verificar si ha ganado
                CheckForWin();
            }
            else
            {
                // Incrementar el contador de errores
                _errorCount++;

                // Actualizar la imagen
                HangmanImage.Source = $"hangman_{_errorCount}.png";

                // Verificar si ha perdido
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
            if (!_guessedLetters.Contains(letter))
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
        if (_errorCount >= MAX_ERRORS)
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
        StartNewGame();
    }
}