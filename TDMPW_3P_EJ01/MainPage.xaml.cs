namespace TDMPW_3P_EJ01;

public partial class MainPage : ContentPage
{
	int count = 0;

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

	private void OnSldChange(object sender, EventArgs e)
	{
		this.txtSld.Text = this.sldPrincipal.Value.ToString("N0");
	}

	private void OnSldR(object sender, EventArgs e)
	{
		this.txtR.Rotation = this.sldR.Value;
	}
}

