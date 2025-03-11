namespace PerfectPay;

public partial class MainPage : ContentPage
{
    public MainPage()
    {
        InitializeComponent();
    }

    private void OnSliderPeopleValueChanged(object sender, ValueChangedEventArgs e)
    {
        int people = (int)sldrAmountPeople.Value;
        peopleAmountLbl.Text = people == 1 ? "1 persona" : $"{people} personas";
    }

    private void OnSliderTipValueChanged(object sender, ValueChangedEventArgs e)
    {
        int tipPercentage = (int)sldrTipPercentage.Value;
        tipPercentageLbl.Text = $"{tipPercentage}%";
        UpdateTipInfo(tipPercentage);
    }

    private void UpdateTipInfo(int tipPercentage)
    {
        tipInfoLbl.Text = $"INCLUYE {tipPercentage}% DE PROPINA";
    }

    private void OnCalculateClicked(object sender, EventArgs e)
    {
        // Verificamos si el valor en el Entry de monto total es un número válido.
        if (string.IsNullOrEmpty(etrTotalAmount.Text) || !decimal.TryParse(etrTotalAmount.Text, out decimal totalAmount))
        {
            // Si no hay número, mostramos 0 en resultAmountLbl.
            resultAmountLbl.Text = "$0.00";
            tipInfoLbl.Text = "INCLUYE 0% DE PROPINA";
            return;
        }

        int tipPercentage = (int)sldrTipPercentage.Value;
        decimal tipAmount = totalAmount * (tipPercentage / 100m); // Usamos 100m para asegurar la precisión decimal.
        decimal totalWithTip = totalAmount + tipAmount;
        int numberOfPeople = (int)sldrAmountPeople.Value;
        decimal amountPerPerson = totalWithTip / numberOfPeople;
        resultAmountLbl.Text = $"${amountPerPerson:F2}";
        UpdateTipInfo(tipPercentage);
    }
}