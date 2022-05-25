import pytest

def test_sum():
    num1=20
    num2=10
    sum=num1+num2
    assert sum == 30

def test_difference():
    num1=20
    num2=10
    diff=num1-num2
    assert diff == 10

@pytest.mark.activity
def test_product():
    num1=20
    num2=10
    prod=num1*num2
    assert prod == 200

@pytest.mark.activity
def test_divide():
    num1=20
    num2=10
    quot=num1/num2
    assert quot == 2

