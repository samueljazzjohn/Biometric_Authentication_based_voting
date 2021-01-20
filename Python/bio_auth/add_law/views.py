from django.shortcuts import render
from django.http import HttpResponse
from add_law.models import Laws


# Create your views here.
def law(request):
    if request.method == "POST":
        obj=Laws()
        obj.description= request.POST.get("des")
        obj.laws=request.POST.get("law")
        obj.save()






    return render(request, 'add_law/postlaw.html')