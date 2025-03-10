using System.Diagnostics;
using CommunityToolkit.Maui.Core;
namespace ColorMaker;
public partial class MainPage : ContentPage
{
	bool isRandom;
	string hexValue = string.Empty; // Initialize with an empty string

	public MainPage()
	{
		InitializeComponent();
	}

	private void Slider_ValueChanged(object sender, ValueChangedEventArgs e)
	{
		if(!isRandom)
		{
			var red = sldRed.Value;
			var green = sldGreen.Value;
			var blue = sldBlue.Value;

			Color color = Color.FromRgb(red, green, blue);

			SetColor(color);
		}
	}

	private void SetColor(Color color)
	{
		Debug.WriteLine(color.ToString());
		hexValue = color.ToHex();
		lblHex.Text = hexValue;
		colorPreview.BackgroundColor = color;
	}

	private async void btnRandom_Clicked(object sender, EventArgs e)
	{
		isRandom = true;
		var random = new Random();

		var color = Color.FromRgb(
			random.Next(0,256),
			random.Next(0, 256),
			random.Next(0, 256));

		SetColor(color);

		sldRed.Value = color.Red;
		sldGreen.Value = color.Green;
		sldBlue.Value = color.Blue;
		isRandom = false;

		// Added clipboard functionality from ImageButton_Clicked
		await Clipboard.SetTextAsync(hexValue);
		var toast = CommunityToolkit.Maui.Alerts.Toast.Make("Color copied",
			CommunityToolkit.Maui.Core.ToastDuration.Short,
			12);
		await toast.Show();
	}
}