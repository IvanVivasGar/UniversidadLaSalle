namespace TDMPW_3P_PR01;

public partial class MainPage : TabbedPage
{

	public MainPage()
	{
		InitializeComponent();
	}

	private void OnSldChange1(object sender, EventArgs e)
	{
		this.lblValue1.Text = this.sldr1.Value.ToString("N0");
	}

	private void OnSldChange2(object sender, EventArgs e)
	{
		this.lblValue2.Text = this.sldr2.Value.ToString("N0");
	}

	private void OnSldChange3(object sender, EventArgs e)
	{
		this.lblValue3.Text = this.sldr3.Value.ToString("N0");
	}

	private void EntryChanged(object sender, EventArgs e)
	{
		this.lblNameHobbies.Text = this.nameEntry.Text;
	}

	private void OnSwitchToggled(object sender, EventArgs e)
	{
		if(sldr4.IsEnabled == false){
			this.sldr4.IsEnabled = true;
		}else{
			this.sldr4.IsEnabled = false;
		}
	}

	private void OnStepperValueChanged(object sender, EventArgs e)
	{
		this.sldr4.Value = this.stp1.Value;
		this.lblValue4.Text = this.stp1.Value.ToString("N0");
	}

	private void OnSldChange4(object sender, EventArgs e)
	{
		this.stp1.Value = this.sldr4.Value;
		this.lblValue4.Text = this.sldr4.Value.ToString("N0");
	}

	private void EntryChanged1(object sender, EventArgs e)
	{
		this.lblHobbie1.Text = this.nameEntry1.Text;
	}
}