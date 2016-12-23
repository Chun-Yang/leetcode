import re

class Solution(object):
    def validIPAddress(self, IP):
        """
        :type IP: str
        :rtype: str
        """
        def isIPv4(str):
            segments = str.split('.')
            if len(segments) != 4:
                return False
            for segment in segments:
                if not re.compile('^\d{1,3}$').match(segment):
                    return False
                if re.compile('^0\d').match(segment):
                    return False
                if int(segment) > 255:
                    return False
            return True

        if isIPv4(IP):
            return 'IPv4'

        def isIPv6(str):
            segments = str.split(':')
            if len(segments) != 8:
                return False
            for segment in segments:
                if not re.compile('^[a-fA-F0-9]{1,4}$').match(segment):
                    return False

            return True

        if isIPv6(IP):
            return 'IPv6'

        return 'Neither'
