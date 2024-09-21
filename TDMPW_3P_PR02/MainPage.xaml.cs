namespace TDMPW_3P_PR02;

public partial class MainPage : ContentPage
{

	public MainPage()
	{
		InitializeComponent();
	}

	private double ShippingAmount(){
		double shipping = 0;
		if (this.quantityEntry.Text != null && double.TryParse(this.quantityEntry.Text, out double quantity)){
			if (quantity <= 100){
				this.shippingLbl.Text = "$ 200.0";
				shipping = 200;
			}else if (quantity <= 300){
				this.shippingLbl.Text = "$ 100.0";
				shipping = 100;
			}else{
				this.shippingLbl.Text = "$ 0.00";
				shipping = 0;
			}
		}
		return shipping;
	}

	private double TaxesAmount(){
		double taxes = 0;
		if (this.quantityEntry.Text != null && double.TryParse(this.quantityEntry.Text, out double quantity2)){
			if (sldr.Value == 11){
				this.taxesLbl.Text = "$ " + (quantity2 * 0.11).ToString("F2");
				taxes = quantity2 * 0.11;
			}else if (sldr.Value == 16){
				this.taxesLbl.Text = "$ " + (quantity2 * 0.16).ToString("F2");
				taxes = quantity2 * 0.16;
			}else {
				this.taxesLbl.Text = "$ 0.00";
				taxes = 0;
			}
		}
		return taxes;
	}

	private void OnQuantityChanged(object sender, EventArgs e){
		if (this.quantityEntry.Text != null && double.TryParse(this.quantityEntry.Text, out double quantity3)){
			this.quantityMain.Text = "$ " + (ShippingAmount() + TaxesAmount() + quantity3);
		}
	}

	private void OnCounterClicked0(object sender, EventArgs e){
		this.sldr.Value = 0;
		TaxesAmount();
		if (this.quantityEntry.Text != null && double.TryParse(this.quantityEntry.Text, out double quantity3)){
			this.quantityMain.Text = "$ " + (ShippingAmount() + TaxesAmount() + quantity3);
		}
	}

	private void OnCounterClicked11(object sender, EventArgs e){
		this.sldr.Value = 11;
		TaxesAmount();
		if (this.quantityEntry.Text != null && double.TryParse(this.quantityEntry.Text, out double quantity3)){
			this.quantityMain.Text = "$ " + (ShippingAmount() + TaxesAmount() + quantity3);
		}
	}

	private void OnCounterClicked16(object sender, EventArgs e){
		this.sldr.Value = 16;
		TaxesAmount();
		if (this.quantityEntry.Text != null && double.TryParse(this.quantityEntry.Text, out double quantity3)){
			this.quantityMain.Text = "$ " + (ShippingAmount() + TaxesAmount() + quantity3);
		}
	}
}