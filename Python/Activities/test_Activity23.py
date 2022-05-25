import pytest

def test_sumlist(test_list):
    sum=0
    for x in test_list:
        sum+=x
    assert sum==55