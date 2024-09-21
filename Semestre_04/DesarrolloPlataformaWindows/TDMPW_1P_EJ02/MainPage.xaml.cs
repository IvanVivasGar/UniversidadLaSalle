using MauiApp1;

namespace TDMPW_1P_EJ02;

public partial class MainPage : ContentPage
{
	int count = 0;

	public MainPage()
	{
		InitializeComponent();
	}

	private void OnCounterClicked(object sender, EventArgs e)
	{
		await Navigation.PushAsync(new CalcularView());
	}
}

