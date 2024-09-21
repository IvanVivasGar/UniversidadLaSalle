namespace TDMPW_1P_EJ01;

public partial class MainPage : ContentPage
{
	int count = 0;
	double resultado = 0;

	public MainPage()
	{
		InitializeComponent();
	}

	private void OnCounterClicked(object sender, EventArgs e)
	{
		count++;

		if (count == 1)
			CounterBtn.Text = $"Clicked {count} time";
		else
			CounterBtn.Text = $"Clicked {count} times";

		SemanticScreenReader.Announce(CounterBtn.Text);
	}

	private void Sumar_Clicked(object sender, EventArgs e)
	{
		double num1 = double.Parse(this.txtN1.Text);
		double num2 = double.Parse(this.txtN2.Text);
		this.resultado = num1 + num2;
		this.txtResultado.Text = resultado.ToString();
	}
}

