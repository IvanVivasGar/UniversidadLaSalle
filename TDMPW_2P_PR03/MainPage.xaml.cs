namespace TDMPW_2P_PR03;

public partial class MainPage : TabbedPage
{
	public MainPage()
	{
		InitializeComponent();
	}
	public void ClickedLikeAloy(object sender, EventArgs e)
	{
		this.aloyLabel.Text = "Te gusto este personaje";
	}

	public void ClickedDislikeAloy(object sender, EventArgs e)
	{
		this.aloyLabel.Text = "No te gusto este personaje";
	}

	public void ClickedLikeSylens(object sender, EventArgs e)
	{
		this.sylensLabel.Text = "Te gusto este personaje";
	}

	public void ClickedDislikeSylens(object sender, EventArgs e)
	{
		this.sylensLabel.Text = "No te gusto este personaje";
	}
}