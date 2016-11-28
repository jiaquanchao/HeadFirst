from django.shortcuts import render

# Create your views here.
from django.http import HttpResponse

def hello(request):
    return HttpResponse("Hello world")

def hello1(request, num):
	try:
	    num = int(num)
	except Exception:
		raise Http404()

def h(request, num):
	return HttpResponse("Hello world"+str(num))

