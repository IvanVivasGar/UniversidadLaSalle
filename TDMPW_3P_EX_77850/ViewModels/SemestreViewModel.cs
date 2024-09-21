using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using TDMPW_3P_EX_77850.Models;

namespace TDMPW_3P_EX_77850.ViewModels;

public partial class SemestreViewModel : ObservableObject
{
    [ObservableProperty]
    private Semestre _semestre;

    public SemestreViewModel(){
        Semestre = new Semestre{
            Nombre = "Materia",
            ValorParciales = "20, 20, 60",
            CalificacionParciales = "8, 9, 7"
        };
    }

    [RelayCommand]
    private void ActualizarNombre(String nuevoNombre){
        Semestre.Nombre = nuevoNombre;
        OnPropertyChanged(nameof(Semestre));
    }

    [RelayCommand]
    private void ActualizarValorParciales(String nuevosValoresParciales){
        Semestre.ValorParciales = nuevosValoresParciales;
        OnPropertyChanged(nameof(Semestre));
    }

    [RelayCommand]
    private void ActualizarCalificacionParciales(String nuevasCalificacionesParciales){
        Semestre.CalificacionParciales = nuevasCalificacionesParciales;
        OnPropertyChanged(nameof(Semestre));
    }
}