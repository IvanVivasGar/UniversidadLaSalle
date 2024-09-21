namespace TDMPW_3P_EJ02;

public partial class MainPage : ContentPage
{
	public MainPage()
	{
		InitializeComponent();
	}

	private void btnFondo_Clicked(object sender, EventArgs e){
		int i = 1;
		Random random = new Random();

		var startColor = Color.FromRgb(
			random.Next(0, 256),
			random.Next(0, 256),
			random.Next(0, 256));

		var endColor = Color.FromRgb(
			random.Next(0, 256),
			random.Next(0, 256),
			random.Next(0, 256));

		var colors = GetColorList(startColor, endColor, 6);
		var stops = new GradientStopCollection();
		foreach(var c in colors){
			string hexColor = ColorToHex(c);
			stops.Add(new GradientStop(c, (float)(i - 1) / 5));
			switch(i){
				case 1:
					lbl1.Text = hexColor;
					break;
				case 2:
					lbl2.Text = hexColor;
					break;
				case 3:
					lbl3.Text = hexColor;
					break;
				case 4:
					lbl4.Text = hexColor;
					break;
				case 5:
					lbl5.Text = hexColor;
					break;
				case 6:
					lbl6.Text = hexColor;
					break;
			}

			i++;
		}

		var gradient = new LinearGradientBrush(stops){
			StartPoint = new Point(0, 0),
			EndPoint = new Point(1, 1)
		};

		grdBG.Background = gradient;
	}

	private List<Color> GetColorList(Color startColor, Color endColor, int steps){
		var colorList = new List<Color>();

		for(int i = 0; i < steps; i++){
			float ratio = (float)i / (steps - 1);
			int r = (int)(startColor.Red * 255 + (endColor.Red - startColor.Red * 255) * ratio);
			int g = (int)(startColor.Green * 255 + (endColor.Green - startColor.Green * 255) * ratio);
			int b = (int)(startColor.Blue * 255 + (endColor.Blue - startColor.Blue * 255) * ratio);
			colorList.Add(Color.FromRgb(r, g, b));
		}

		return colorList;
	}

	private string ColorToHex(Color color){
		int r = (int)(color.Red * 255);
		int g = (int)(color.Green * 255);
		int b = (int)(color.Blue * 255);

		return $"#{r:X2}{g:X2}{b:X2}";
	}
}

